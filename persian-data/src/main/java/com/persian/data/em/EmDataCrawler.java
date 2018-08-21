package com.persian.data.em;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.persian.data.DataCrawler;
import com.persian.data.IndexType;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.StringReader;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author: dave01.zhou  Time: 2018/8/2 16:30
 */
public class EmDataCrawler extends DataCrawler {
    private static final Logger logger = LoggerFactory.getLogger(EmDataCrawler.class);

    public List<EmStockCnHkFlow> stockCnHkFlow() {
        return commonQuery(EmApi.CN_HK_FLOW, data -> {
            try {
                List<EmStockCnHkFlow> results = jsonMapper.readValue(data, new TypeReference<List<EmStockCnHkFlow>>() {
                });
                for (EmStockCnHkFlow flow : results) {
                    flow.setDateTime(flow.getDateTime().substring(0, 10));
                }
                return results;
            } catch (Exception e) {
                logger.error("Parsing error for cn-hk flow data: " + data, e);
                e.printStackTrace();
            }
            return Collections.emptyList();
        });
    }

    public Map<String, EmStockUnlock> stockUnlock(LocalDate date) {
        if (date == null) {
            date = LocalDate.now();
        }
        String[] columnList = Stream.of(EmStockUnlock.class.getDeclaredFields())
                .map(x -> x.getName()).toArray(String[]::new);
        CsvSchema csvSchema = csvMapper.schemaFor(EmStockUnlock.class)
                .sortedBy(columnList)
                .withoutQuoteChar();
        ObjectReader dataReader = csvMapper.readerFor(EmStockUnlock.class).with(csvSchema);
        String url = String.format(EmApi.RESTRICTED_UNLOCK, date.getYear(), date.getMonthValue());
        return commonQuery(url, data -> {
            try {
                // 查不到的年份返回的数据
                if (data.contains("([{stats:false}])")) {
                    return Collections.emptyMap();
                }
                String dataEntity = data.substring(1, data.length() - 1);
                ArrayNode nodeList = (ArrayNode) jsonMapper.readTree(dataEntity);
                Map<String, EmStockUnlock> results = new LinkedHashMap<>();
                for (JsonNode node : nodeList) {
                    EmStockUnlock stockObj = dataReader.readValue(node.toString());
                    results.put(stockObj.getCode(), stockObj);
                }
                return results;
            } catch (Exception e) {
                logger.error("Parsing error for stock unlock data: " + data, e);

            }
            return Collections.emptyMap();
        });
    }

    public List<EmStockTop10Holders> stockTop10Holders(String codeSymbol) {
        if (codeSymbol == null || codeSymbol.isEmpty()) {
            throw new IllegalArgumentException("Argument codySymbol cannot be empty!");
        }
        String url = String.format(EmApi.TOP10_HOLDERS, codeSymbol.toUpperCase());
        return commonQuery(url, data -> {
            try {
                String allData = new BufferedReader(new StringReader(data)).readLine();
                String dataEntity = allData.substring(allData.indexOf('\'') + 1, allData.length() - 2);
                return jsonMapper.readValue(dataEntity, new TypeReference<List<EmStockTop10Holders>>() {
                });
            } catch (Exception e) {
                logger.error("Parsing error for stock top10 holders data: " + data, e);
            }
            return Collections.emptyList();
        });
    }

    public Map<String, EmStockDesc> stockForIndexCN(IndexType type) {
        if (type == null || !type.isCN()) {
            throw new IllegalArgumentException("Index type error: " + type);
        }
        String url = "";
        switch (type) {
            case SH_50:
                url = EmApi.SH50_LIST;
                break;
            case HS_300:
                url = EmApi.HS300_LIST;
                break;
            case ZZ_500:
                url = EmApi.ZZ500_LIST;
                break;
            default:
                throw new IllegalArgumentException("Current not support index type: " + type);
        }
        return commonDownloadSync(url, is -> {
            try {
                // Excel 2003 format(*.xls), use XSSFWorkbook for excel 2007+(*.xlsx)
                Workbook book = new HSSFWorkbook(is);
                Sheet sheet = book.getSheetAt(0);
                int count = 0;
                Map<String, EmStockDesc> results = new LinkedHashMap<>();
                for (Row row : sheet) {
                    if (count < 1) {
                        count++;
                        continue;
                    }
                    if (row.getLastCellNum() > 5) {
                        EmStockDesc stockDesc = new EmStockDesc();
                        stockDesc.setCode(row.getCell(4).toString());
                        stockDesc.setNameCn(row.getCell(5).toString());
                        if (row.getLastCellNum() > 8) {
                            stockDesc.setWeight(row.getCell(8).toString());
                        }
                        results.put(stockDesc.getCode(), stockDesc);
                    }
                }
                return results;
            } catch (Exception e) {
                logger.error("Parsing error for stock excel file", e);
            }
            return Collections.emptyMap();
        });
    }
}
