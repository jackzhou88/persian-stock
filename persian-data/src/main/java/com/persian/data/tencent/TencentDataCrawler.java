package com.persian.data.tencent;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.persian.data.DataCrawler;
import com.persian.data.IndexType;
import com.persian.data.KLineType;
import com.persian.data.StockType;
import com.persian.data.util.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Year;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author: dave01.zhou  Time: 2018/7/28 1:53
 */
public class TencentDataCrawler extends DataCrawler {
    private static final Logger logger = LoggerFactory.getLogger(TencentDataCrawler.class);
    private static final char FIELD_SEPARATOR1 = '~';
    private static final char FIELD_SEPARATOR2 = ' ';

    private <T> Map<String, T> queryBulk(StockType type, Class<T> pojoClass, String codeFormat) {
        String[] columnList = Stream.of(pojoClass.getDeclaredFields())
                .map(x -> x.getName()).toArray(String[]::new);
        CsvSchema dataSchema = csvMapper.schemaFor(pojoClass)
                .sortedBy(columnList)
                .withColumnSeparator(FIELD_SEPARATOR1)
                .withoutQuoteChar();
        ObjectReader dataReader = csvMapper.readerFor(pojoClass).with(dataSchema);
        return stockQueryBulk(type, TencentApi.QT_SERVICE,
                code -> String.format(codeFormat, code),
                (data, results) -> {
                    try {
                        String[] stockList = data.split(LINE_SEPARATOR);
                        for (String stock : stockList) {
                            if (stock.indexOf(FIELD_SEPARATOR1) < 0) {
                                continue;
                            }
                            String code = stock.substring(stock.indexOf(type.getSymbol()) + type.getSymbol().length(), stock.indexOf('='));
                            String dataEntity = stock.substring(stock.indexOf(DOUBLE_QUOTE) + 1, stock.lastIndexOf(DOUBLE_QUOTE));
                            T stockObj = dataReader.readValue(dataEntity);
                            if (stockObj instanceof TencentStockCaptialFlow) {
                                ((TencentStockCaptialFlow) stockObj).setCode(code);
                            }
                            results.put(code, stockObj);
                        }
                    } catch (Exception e) {
                        logger.error("Parsing error for stock data: " + data, e);
                    }
                });
    }

    private <T> T querySingle(String url, Class<T> pojoClass) {
        String[] columnList = Stream.of(pojoClass.getDeclaredFields())
                .map(x -> x.getName()).toArray(String[]::new);
        CsvSchema dataSchema = csvMapper.schemaFor(pojoClass)
                .sortedBy(columnList)
                .withColumnSeparator(FIELD_SEPARATOR1)
                .withoutQuoteChar();
        ObjectReader dataReader = csvMapper.readerFor(pojoClass).with(dataSchema);
        return commonQuery(url, data -> {
            try {
                //String code = data.substring(data.indexOf(type.getSymbol()) + type.getSymbol().length(), data.indexOf('='));
                String dataEntity = data.substring(data.indexOf(DOUBLE_QUOTE) + 1, data.lastIndexOf(DOUBLE_QUOTE));
                T stockObj = dataReader.readValue(dataEntity);
                //stockObj.setCode(code)
                return stockObj;
            } catch (Exception e) {
                logger.error("Parsing error for stock data: " + data, e);
            }
            return null;
        });
    }

    public Map<String, TencentStockRealtimeSimple> stockRealtimeSimpleCN(StockType type) {
        if (type == null || !type.isCN()) {
            throw new IllegalArgumentException("Stock type error: " + type);
        }
        return queryBulk(type, TencentStockRealtimeSimple.class, "s_" + type.getSymbol() + STOCK_CODE_FORMAT);
    }

    public Map<String, TencentStockRealtimeDetail> stockRealtimeDetailCN(StockType type) {
        if (type == null || !type.isCN()) {
            throw new IllegalArgumentException("Stock type error: " + type);
        }
        return queryBulk(type, TencentStockRealtimeDetail.class, type.getSymbol() + STOCK_CODE_FORMAT);
    }

    public Map<String, TencentStockCaptialFlow> stockCaptialFlowCN(StockType type) {
        if (type == null || !type.isCN()) {
            throw new IllegalArgumentException("Stock type error: " + type);
        }
        return queryBulk(type, TencentStockCaptialFlow.class, "ff_" + type.getSymbol() + STOCK_CODE_FORMAT);
    }

    public Map<String, TencentStockDiskAnalysis> stockDiskAnalysisCN(StockType type) {
        if (type == null || !type.isCN()) {
            throw new IllegalArgumentException("Stock type error: " + type);
        }
        return queryBulk(type, TencentStockDiskAnalysis.class, "s_pk" + type.getSymbol() + STOCK_CODE_FORMAT);
    }

    public TencentStockRealtimeSimple indexRealtimeSimpleCN(IndexType type) {
        if (type == null || !type.isCN()) {
            throw new IllegalArgumentException("Index type error: " + type);
        }
        return querySingle(String.format(TencentApi.QT_SERVICE, "s_" + type.getSymbol() + type.getCode()),
                TencentStockRealtimeSimple.class);
    }

    public EnumMap<IndexType, TencentStockRealtimeSimple> indexRealtimeSimpleCN() {
        EnumMap<IndexType, TencentStockRealtimeSimple> results = new EnumMap<>(IndexType.class);
        for (IndexType type : IndexType.values()) {
            if (type.isCN()) {
                TencentStockRealtimeSimple indexObj = querySingle(String.format(TencentApi.QT_SERVICE, "s_" + type.getSymbol() + type.getCode()),
                        TencentStockRealtimeSimple.class);
                results.put(type, indexObj);
            }
        }
        return results;
    }

    public TencentStockRealtimeDetail indexRealtimeDetailCN(IndexType type) {
        if (type == null || !type.isCN()) {
            throw new IllegalArgumentException("Index type error: " + type);
        }
        return querySingle(String.format(TencentApi.QT_SERVICE, type.getSymbol() + type.getCode()),
                TencentStockRealtimeDetail.class);
    }

    public EnumMap<IndexType, TencentStockRealtimeDetail> indexRealtimeDetailCN() {
        EnumMap<IndexType, TencentStockRealtimeDetail> results = new EnumMap<>(IndexType.class);
        for (IndexType type : IndexType.values()) {
            if (type.isCN()) {
                TencentStockRealtimeDetail indexObj = querySingle(String.format(TencentApi.QT_SERVICE, type.getSymbol() + type.getCode()),
                        TencentStockRealtimeDetail.class);
                results.put(type, indexObj);
            }
        }
        return results;
    }

    private List<TencentStockKLine> queryKline(String codeSymbol, String url) {
        String[] columnList = Stream.of(TencentStockKLine.class.getDeclaredFields())
                .map(x -> x.getName()).toArray(String[]::new);
        CsvSchema dataSchema = csvMapper.schemaFor(TencentStockKLine.class)
                .sortedBy(columnList)
                .withColumnSeparator(FIELD_SEPARATOR2)
                .withoutQuoteChar();
        ObjectReader dataReader = csvMapper.readerFor(TencentStockKLine.class).with(dataSchema);
        return commonQuery(url, data -> {
            try {
                String dataEntity = data.substring(data.indexOf(DOUBLE_QUOTE) + 1, data.lastIndexOf(DOUBLE_QUOTE));
                TencentStockKLine[] results = Stream.of(dataEntity.split(LINE_SEPARATOR))
                        .skip(1L)
                        .filter(x -> x.indexOf(FIELD_SEPARATOR2) > 0 && !x.startsWith("num:"))
                        .map(Try.of(x -> dataReader.readValue(x.substring(0, x.length() - 3)), null))
                        .toArray(TencentStockKLine[]::new);
                return Arrays.asList(results);
            } catch (Exception e) {
                logger.error(String.format("Parsing error for stock: %s, kline data: %s\n", codeSymbol, data), e);
            }
            return Collections.emptyList();
        });
    }

    public List<TencentStockKLine> stockKLineLatest(String codeSymbol, KLineType kType) {
        if (codeSymbol == null || codeSymbol.isEmpty() || kType == null) {
            throw new IllegalArgumentException("Argument codeSymbol or kType cannot be null!");
        }
        String url = String.format(TencentApi.KLINE_LATEST, kType.name().toLowerCase(), codeSymbol);
        return queryKline(codeSymbol, url);
    }

    public List<TencentStockKLine> stockKLineDailyForYear(String codeSymbol, Year year) {
        if (codeSymbol == null || codeSymbol.isEmpty()) {
            throw new IllegalArgumentException("Argument codeSymbol cannot be empty!");
        }
        if (year == null) {
            year = Year.now();
        }
        String yearStr = year.toString();
        yearStr = yearStr.substring(yearStr.length() - 2);
        String url = String.format(TencentApi.KLINE_DAILY_YEAR, yearStr, codeSymbol);
        return queryKline(codeSymbol, url);
    }

    public List<TencentStockMinuteLine> stockMinuteLineLatest(String codeSymbol) {
        if (codeSymbol == null || codeSymbol.isEmpty()) {
            throw new IllegalArgumentException("Argument codeSymbol cannot be empty!");
        }

        String url = String.format(TencentApi.MINUTE_LINE_LATEST, codeSymbol);
        String[] columnList = Stream.of(TencentStockMinuteLine.class.getDeclaredFields())
                .map(x -> x.getName()).toArray(String[]::new);
        CsvSchema dataSchema = csvMapper.schemaFor(TencentStockMinuteLine.class)
                .sortedBy(columnList)
                .withColumnSeparator(FIELD_SEPARATOR2)
                .withoutQuoteChar();
        ObjectReader dataReader = csvMapper.readerFor(TencentStockMinuteLine.class).with(dataSchema);
        return commonQuery(url, data -> {
            try {
                String dataEntity = data.substring(data.indexOf(DOUBLE_QUOTE) + 1, data.lastIndexOf(DOUBLE_QUOTE));
                TencentStockMinuteLine[] results = Stream.of(dataEntity.split(LINE_SEPARATOR))
                        .skip(2L)
                        .map(Try.of(x -> dataReader.readValue(x.substring(0, x.length() - 3)), null))
                        .toArray(TencentStockMinuteLine[]::new);
                return Arrays.asList(results);
            } catch (Exception e) {
                logger.error(String.format("Parsing error for stock: %s, minute line data: %s\n", codeSymbol, data), e);
            }
            return Collections.emptyList();
        });
    }

}
