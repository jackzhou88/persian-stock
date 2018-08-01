package com.persian.data.sina;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.persian.data.DataCrawler;
import com.persian.data.IndexType;
import com.persian.data.StockType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.stream.Stream;

/**
 * @author: dave01.zhou  Time: 2018/7/26 0:20
 */
public class SinaDataCrawler extends DataCrawler {
    private static final Logger logger = LoggerFactory.getLogger(SinaDataCrawler.class);
    private static final char FIELD_SEPARATOR = ',';

    private <T> Map<String, T> queryBulk(StockType type, Class<T> pojoClass, String codeFormat) {
        String[] columnList = Stream.of(pojoClass.getDeclaredFields())
                .map(x -> x.getName()).toArray(String[]::new);
        CsvSchema dataSchema = csvMapper.schemaFor(pojoClass)
                .sortedBy(columnList)
                .withColumnSeparator(FIELD_SEPARATOR)
                .withoutQuoteChar();
        ObjectReader dataReader = csvMapper.readerFor(pojoClass).with(dataSchema);
        return stockQueryBulk(type, SinaApi.HQ_SERVICE,
                code -> String.format(codeFormat, code),
                (data, results) -> {
                    try {
                        String[] stockList = data.split(LINE_SEPARATOR);
                        for (String stock : stockList) {
                            if (stock.indexOf(FIELD_SEPARATOR) < 0) {
                                continue;
                            }
                            String code = stock.substring(stock.indexOf(type.getSymbol()) + type.getSymbol().length(), stock.indexOf('='));
                            String dataEntity = stock.substring(stock.indexOf('=') + 1);
                            T stockObj = dataReader.readValue(dataEntity);
                            //stockObj.setCode(code)
                            results.put(code, stockObj);
                        }
                    } catch (Exception e) {
                        logger.error("Parsing error for stock data: " + data, e);
                    }
                });
    }

    private <T> T querySingle(Class<T> pojoClass, String url) {
        String[] columnList = Stream.of(pojoClass.getDeclaredFields())
                .map(x -> x.getName()).toArray(String[]::new);
        CsvSchema dataSchema = csvMapper.schemaFor(pojoClass)
                .sortedBy(columnList)
                .withColumnSeparator(FIELD_SEPARATOR)
                .withoutQuoteChar();
        ObjectReader dataReader = csvMapper.readerFor(pojoClass).with(dataSchema);
        return commonQuery(url, data -> {
            try {
                //String code = data.substring(data.indexOf(type.getSymbol()) + type.getSymbol().length(), data.indexOf('='));
                String dataEntity = data.substring(data.indexOf('=') + 1);
                T stockObj = dataReader.readValue(dataEntity);
                //stockObj.setCode(code)
                return stockObj;
            } catch (Exception e) {
                logger.error("Parsing error for stock data: " + data, e);
            }
            return null;
        });
    }

    public Map<String, SinaStockRealtimeSimple> stockRealtimeSimpleCN(StockType type) {
        if (type == null || !type.isCN()) {
            throw new IllegalArgumentException("Stock type error: " + type);
        }
        return queryBulk(type, SinaStockRealtimeSimple.class, "s_" + type.getSymbol() + STOCK_CODE_FORMAT);
    }

    public Map<String, SinaStockRealtimeDetail> stockRealtimeDetailCN(StockType type) {
        if (type == null || !type.isCN()) {
            throw new IllegalArgumentException("Stock type error: " + type);
        }
        return queryBulk(type, SinaStockRealtimeDetail.class, type.getSymbol() + STOCK_CODE_FORMAT);
    }

    public Map<String, SinaStockFinancialInfo> stockFinancialInfoCN(StockType type) {
        if (type == null || !type.isCN()) {
            throw new IllegalArgumentException("Stock type error: " + type);
        }
        return queryBulk(type, SinaStockFinancialInfo.class, type.getSymbol() + STOCK_CODE_FORMAT + "_i");
    }

    public SinaStockRealtimeSimple indexRealtimeSimpleCN(IndexType type) {
        if (type == null || !type.isCN()) {
            throw new IllegalArgumentException("Index type error: " + type);
        }
        return querySingle(SinaStockRealtimeSimple.class,
                String.format(SinaApi.HQ_SERVICE, "s_" + type.getSymbol() + type.getCode()));
    }

    public SinaStockRealtimeDetail indexRealtimeDetailCN(IndexType type) {
        if (type == null || !type.isCN()) {
            throw new IllegalArgumentException("Index type error: " + type);
        }
        return querySingle(SinaStockRealtimeDetail.class,
                String.format(SinaApi.HQ_SERVICE, type.getSymbol() + type.getCode()));
    }

}
