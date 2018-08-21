package com.persian.data.sina;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.persian.data.*;
import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Stream;

/**
 * @author: dave01.zhou  Time: 2018/7/26 0:20
 */
public class SinaDataCrawler extends DataCrawler {
    private static final Logger logger = LoggerFactory.getLogger(SinaDataCrawler.class);
    private static final int QUARTER_COUNT = 20;
    private static final char FIELD_SEPARATOR1 = ',';
    private static final char FIELD_SEPARATOR2 = '\t';
    private static final CsvMapper statementMapper = new CsvMapper()
            .enable(CsvParser.Feature.TRIM_SPACES)
            .enable(CsvParser.Feature.WRAP_AS_ARRAY)
            .enable(CsvParser.Feature.IGNORE_TRAILING_UNMAPPABLE)
            .enable(CsvParser.Feature.SKIP_EMPTY_LINES);

    static {
        // 隐式地初始化JavaFX runtime，以避免在创建javafx Image时
        // 抛出：java.lang.RuntimeException: Internal graphics not initialized yet.
        new JFXPanel();
    }

    private <T> Map<String, T> queryBulk(StockType type, Class<T> pojoClass, String codeFormat) {
        String[] columnList = Stream.of(pojoClass.getDeclaredFields())
                .map(x -> x.getName()).toArray(String[]::new);
        CsvSchema dataSchema = csvMapper.schemaFor(pojoClass)
                .sortedBy(columnList)
                .withColumnSeparator(FIELD_SEPARATOR1)
                .withoutQuoteChar();
        ObjectReader dataReader = csvMapper.readerFor(pojoClass).with(dataSchema);
        return stockQueryBulk(type, SinaApi.HQ_SERVICE,
                code -> String.format(codeFormat, code),
                (data, results) -> {
                    try {
                        String[] stockList = data.split(LINE_SEPARATOR);
                        for (String stock : stockList) {
                            if (stock.indexOf(FIELD_SEPARATOR1) < 0) {
                                continue;
                            }
                            String endStr = (pojoClass == SinaStockBasicInfo.class ? "_i=" : "=");
                            String code = stock.substring(stock.indexOf(type.getSymbol()) + type.getSymbol().length(), stock.indexOf(endStr));
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

    public Map<String, SinaStockBasicInfo> stockBasicInfoCN(StockType type) {
        if (type == null || !type.isCN()) {
            throw new IllegalArgumentException("Stock type error: " + type);
        }
        return queryBulk(type, SinaStockBasicInfo.class, type.getSymbol() + STOCK_CODE_FORMAT + "_i");
    }

    public SinaStockRealtimeSimple indexRealtimeSimpleCN(IndexType type) {
        if (type == null || !type.isCN()) {
            throw new IllegalArgumentException("Index type error: " + type);
        }
        return querySingle(String.format(SinaApi.HQ_SERVICE, "s_" + type.getSymbol() + type.getCode()),
                SinaStockRealtimeSimple.class);
    }

    public SinaStockRealtimeDetail indexRealtimeDetailCN(IndexType type) {
        if (type == null || !type.isCN()) {
            throw new IllegalArgumentException("Index type error: " + type);
        }
        return querySingle(String.format(SinaApi.HQ_SERVICE, type.getSymbol() + type.getCode()),
                SinaStockRealtimeDetail.class);
    }

    public EnumMap<KLineType, Image> stockKLineChart(String codeSymbol) {
        if (codeSymbol == null || codeSymbol.isEmpty()) {
            throw new IllegalArgumentException("Argument codeSymbol cannot be empty!");
        }
        EnumMap<KLineType, Image> results = new EnumMap<>(KLineType.class);
        for (KLineType type : KLineType.values()) {
            results.put(type, new Image(String.format(SinaApi.KLINE_CHART_LATEST, type.name().toLowerCase(), codeSymbol)));
        }
        return results;
    }

    public Image stockMinuteLineChart(String codeSymbol) {
        if (codeSymbol == null || codeSymbol.isEmpty()) {
            throw new IllegalArgumentException("Argument codeSymbol cannot be empty!");
        }
        String url = String.format(SinaApi.MINUTE_LINE_CHART, codeSymbol);
        return new Image(url);
    }

    public List<SinaStockMinuteLine> stockMinuteLine(String codySymbol, MinuteLineType type) {
        if (codySymbol == null || codySymbol.isEmpty() || type == null) {
            throw new IllegalArgumentException("Argument codeSymbol or type cannot be null!");
        }
        String url = String.format(SinaApi.MINUTE_LINE_DATA, codySymbol, type.getCode());
        return commonQuery(url, data -> {
            try {
                ObjectMapper mapper = new ObjectMapper().enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
                return mapper.readValue(data, new TypeReference<List<SinaStockMinuteLine>>() {
                });
            } catch (Exception e) {
                logger.error("Parsing error for minute line data: " + data, e);
            }
            return Collections.emptyList();
        });
    }

    public Map<String, String> stockPriceRestore(String codeSymbol, boolean isPost) {
        if (codeSymbol == null || codeSymbol.isEmpty()) {
            throw new IllegalArgumentException("Argument codeSymbol cannot be empty!");
        }
        String url = String.format(SinaApi.PRICE_RESTORE_PRE, codeSymbol);
        if (isPost) {
            url = String.format(SinaApi.PRICE_RESTORE_POST, codeSymbol);
        }
        return commonQuery(url, data -> {
            try {
                ObjectMapper mapper = new ObjectMapper()
                        .enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)
                        .enable(JsonParser.Feature.ALLOW_COMMENTS);
                List<String> results1 = mapper.readValue(data, List.class);
                Map<String, String> results2 = mapper.readValue(results1.get(0), Map.class);
                Map<String, String> results = mapper.readValue(results2.get("data"), Map.class);
                return results;
            } catch (Exception e) {
                logger.error("Parsing error for stock data: " + data, e);
            }
            return Collections.emptyMap();
        });
    }

    private <T> List<T> queryStatement(String url, BiFunction<String[][], Integer, T> itemParser) {
        CsvSchema dataSchema = CsvSchema.emptySchema()
                .withColumnSeparator(FIELD_SEPARATOR2);
        ObjectReader dataReader = statementMapper.readerFor(String[][].class).with(dataSchema);
        return commonDownloadSync(url, is -> {
            try {
                InputStreamReader reader = new InputStreamReader(is, "gb2312");
                String[][] sheet = dataReader.readValue(reader);
                int columnNumber = sheet[0].length;
                // 查不到的股票代码返回的数据
                if (columnNumber < 2 || "19700101".equals(sheet[0][1])) {
                    return Collections.emptyList();
                }
                List<T> results = new ArrayList<>();
                int columnCount = (columnNumber > QUARTER_COUNT ? QUARTER_COUNT : columnNumber - 1);
                for (int col = 1; col <= columnCount; ++col) {
                    T statementObj = itemParser.apply(sheet, col);
                    results.add(statementObj);
                }
                return results;
            } catch (Exception e) {
                logger.error("Parsing error for stock data", e);
            }
            return Collections.emptyList();
        });
    }

    public List<SinaStockProfit> stockStatementProfit(String code) {
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Argument code cannot be empty!");
        }
        String url = String.format(SinaApi.STATEMENT_INCOME_PROFIT, code);
        return queryStatement(url, (sheet, quarterNo) -> {
            SinaStockProfit obj = new SinaStockProfit();
            obj.setCode(code);
            obj.setQuarter(sheet[0][quarterNo]);
            obj.setYyzsr(sheet[2][quarterNo]);
            obj.setYyzcb(sheet[4][quarterNo]);
            obj.setXsfy(sheet[7][quarterNo]);
            obj.setGlfy(sheet[8][quarterNo]);
            obj.setCwfy(sheet[9][quarterNo]);
            obj.setTzsy(sheet[12][quarterNo]);
            obj.setYylr(sheet[15][quarterNo]);
            obj.setLrze(sheet[19][quarterNo]);
            obj.setJlr(sheet[21][quarterNo]);
            obj.setMgsy(sheet[25][quarterNo]);
            obj.setZhsyze(sheet[28][quarterNo]);
            return obj;
        });
    }

    public List<SinaStockBalance> stockStatementBalance(String code) {
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Argument code cannot be empty!");
        }
        String url = String.format(SinaApi.STATEMENT_BALANCE_SHEET, code);
        return queryStatement(url, (sheet, quarterNo) -> {
            SinaStockBalance obj = new SinaStockBalance();
            obj.setCode(code);
            obj.setQuarter(sheet[0][quarterNo]);
            obj.setYspj(sheet[6][quarterNo]);
            obj.setYszk(sheet[7][quarterNo]);
            obj.setLdzchj(sheet[19][quarterNo]);
            obj.setGdzj(sheet[27][quarterNo]);
            obj.setWxzj(sheet[34][quarterNo]);
            obj.setSy(sheet[36][quarterNo]);
            obj.setFldzchj(sheet[40][quarterNo]);
            obj.setZchj(sheet[41][quarterNo]);
            obj.setLdfzhj(sheet[59][quarterNo]);
            obj.setFldfzhj(sheet[70][quarterNo]);
            obj.setFzhj(sheet[71][quarterNo]);
            obj.setSyzqy(sheet[83][quarterNo]);
            return obj;
        });
    }

    public List<SinaStockCash> stockStatementCash(String code) {
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Argument code cannot be empty!");
        }
        String url = String.format(SinaApi.STATEMENT_CASH_FLOW, code);
        return queryStatement(url, (sheet, quarterNo) -> {
            SinaStockCash obj = new SinaStockCash();
            obj.setCode(code);
            obj.setQuarter(sheet[0][quarterNo]);
            obj.setJyhd(sheet[12][quarterNo]);
            obj.setTzhd(sheet[5][quarterNo]);
            obj.setCzhd(sheet[38][quarterNo]);
            return obj;
        });
    }

}
