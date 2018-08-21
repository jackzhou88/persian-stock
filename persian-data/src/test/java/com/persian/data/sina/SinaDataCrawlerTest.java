package com.persian.data.sina;

import com.persian.data.IndexType;
import com.persian.data.KLineType;
import com.persian.data.MinuteLineType;
import com.persian.data.StockType;
import javafx.scene.image.Image;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: dave01.zhou  Time: 2018/8/13 16:43
 */
class SinaDataCrawlerTest {
    private SinaDataCrawler crawler = new SinaDataCrawler();
    private Map<String, String> stockExamples = new LinkedHashMap<>();

    @BeforeEach
    void setUp() {
        stockExamples.put("sh600887", "伊利股份");
        stockExamples.put("sh900905", "老凤祥B");
        stockExamples.put("sz000858", "五粮液");
        stockExamples.put("sz200596", "古井贡B");
        stockExamples.put("sz300003", "乐普医疗");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void stockRealtimeSimpleCN() {
        for (StockType type : StockType.values()) {
            if (type.isCN()) {
                long start = System.nanoTime();
                Map<String, SinaStockRealtimeSimple> stocks = crawler.stockRealtimeSimpleCN(type);
                long end = System.nanoTime();
                System.out.printf("Stock %s time consuming: %f seconds\n", type, (end - start) / (double) (1000 * 1000 * 1000));
                assertTrue(stocks.size() > 30);
                System.out.printf("Stock %s count: %d\n", type, stocks.size());
                System.out.println(stocks.keySet());
            }
        }
        assertThrows(IllegalArgumentException.class,
                () -> crawler.stockRealtimeSimpleCN(StockType.HK),
                "Stock type error: " + StockType.HK);
    }

    @Test
    void stockRealtimeDetailCN() {
        for (StockType type : StockType.values()) {
            if (type.isCN()) {
                long start = System.nanoTime();
                Map<String, SinaStockRealtimeDetail> stocks = crawler.stockRealtimeDetailCN(type);
                long end = System.nanoTime();
                System.out.printf("Stock %s time consuming: %f seconds\n", type, (end - start) / (double) (1000 * 1000 * 1000));
                assertTrue(stocks.size() > 30);
                System.out.printf("Stock %s count: %d\n", type, stocks.size());
                System.out.println(stocks.keySet());
            }
        }
        assertThrows(IllegalArgumentException.class,
                () -> crawler.stockRealtimeDetailCN(StockType.HK),
                "Stock type error: " + StockType.HK);
    }

    @Test
    void stockBasicInfoCN() {
        for (StockType type : StockType.values()) {
            if (type.isCN()) {
                long start = System.nanoTime();
                Map<String, SinaStockBasicInfo> stocks = crawler.stockBasicInfoCN(type);
                long end = System.nanoTime();
                System.out.printf("Stock %s time consuming: %f seconds\n", type, (end - start) / (double) (1000 * 1000 * 1000));
                assertTrue(stocks.size() > 30);
                System.out.printf("Stock %s count: %d\n", type, stocks.size());
                System.out.println(stocks.keySet());
            }
        }
        assertThrows(IllegalArgumentException.class,
                () -> crawler.stockBasicInfoCN(StockType.HK),
                "Stock type error: " + StockType.HK);
    }

    @Test
    void indexRealtimeSimpleCN() {
        for (IndexType type : IndexType.values()) {
            if (type.isCN()) {
                SinaStockRealtimeSimple index = crawler.indexRealtimeSimpleCN(type);
                assertNotNull(index);
                System.out.printf("Index %s: %s\n", type, index);
            }
        }
    }

    @Test
    void indexRealtimeDetailCN() {
        for (IndexType type : IndexType.values()) {
            if (type.isCN()) {
                SinaStockRealtimeDetail index = crawler.indexRealtimeDetailCN(type);
                assertNotNull(index);
                System.out.printf("Index %s: %s\n", type, index);
            }
        }
    }

    @Test
    void stockKLineChart() {
        for (Map.Entry<String, String> stock : stockExamples.entrySet()) {
            EnumMap<KLineType, Image> klineCharts = crawler.stockKLineChart(stock.getKey());
            for (EnumMap.Entry<KLineType, Image> chart : klineCharts.entrySet()) {
                System.out.printf("%s %s kline chart: width %f, height %f\n", stock.getKey(), chart.getKey().name(),
                        chart.getValue().getWidth(), chart.getValue().getHeight());
            }
        }
        EnumMap<KLineType, Image> klineCharts = crawler.stockKLineChart("abc");
        assertFalse(klineCharts.isEmpty());
        Image chart = crawler.stockMinuteLineChart("sh600887");
        System.out.printf("\nsh600887 minute line chart: width %f, height %f\n", chart.getWidth(), chart.getHeight());
        assertThrows(IllegalArgumentException.class, () -> crawler.stockKLineChart(null),
                "Argument codeSymbol cannot be empty!");
    }

    @Test
    void stockMinuteLine() {
        for (Map.Entry<String, String> stock : stockExamples.entrySet()) {
            for (MinuteLineType type : MinuteLineType.values()) {
                List<SinaStockMinuteLine> minuteLines = crawler.stockMinuteLine(stock.getKey(), type);
                System.out.printf("%s,%s one minute %s line data: %s\n", stock.getKey(), stock.getValue(),
                        type.getCode(), minuteLines.get(0));
            }
        }
        List<SinaStockMinuteLine> minuteLines = crawler.stockMinuteLine("abc", MinuteLineType.MINUTE_5);
        assertTrue(minuteLines == null || minuteLines.isEmpty());
        assertThrows(IllegalArgumentException.class,
                () -> crawler.stockMinuteLine(null, null),
                "Argument codeSymbol or type cannot be null!");
    }

    @Test
    void stockPriceRestore() {
        for (Map.Entry<String, String> stock : stockExamples.entrySet()) {
            Map<String, String> results = crawler.stockPriceRestore(stock.getKey(), false);
            for (Map.Entry<String, String> restore : results.entrySet()) {
                System.out.printf("%s,%s one price restore data: %s\n", stock.getKey(), stock.getValue(),
                        restore.toString());
                break;
            }
        }
    }

    @Test
    void stockStatement() {
        for (Map.Entry<String, String> stock : stockExamples.entrySet()) {
            String code = stock.getKey().substring(2);
            List<SinaStockProfit> profits = crawler.stockStatementProfit(code);
            assertTrue(profits.size() == 20);
            System.out.printf("%s,%s one profit statement: %s\n", code, stock.getValue(), profits.get(0));
            List<SinaStockBalance> balances = crawler.stockStatementBalance(code);
            assertTrue(balances.size() == 20);
            System.out.printf("%s,%s one balance statement: %s\n", code, stock.getValue(), balances.get(0));
            List<SinaStockCash> cash = crawler.stockStatementCash(code);
            assertTrue(cash.size() == 20);
            System.out.printf("%s,%s one cash statement: %s\n\n", code, stock.getValue(), cash.get(0));
        }
        List<SinaStockProfit> profits = crawler.stockStatementProfit("abc");
        assertTrue(profits.isEmpty());
        assertThrows(IllegalArgumentException.class, () -> crawler.stockStatementProfit(null),
                "Argument code cannot be empty!");
    }

}