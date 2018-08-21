package com.persian.data.tencent;

import com.persian.data.IndexType;
import com.persian.data.KLineType;
import com.persian.data.StockType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: dave01.zhou  Time: 2018/8/13 17:20
 */
class TencentDataCrawlerTest {
    private TencentDataCrawler crawler = new TencentDataCrawler();
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
                Map<String, TencentStockRealtimeSimple> stocks = crawler.stockRealtimeSimpleCN(type);
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
    public void stockRealtimeDetailCN() {
        for (StockType type : StockType.values()) {
            if (type.isCN()) {
                long start = System.nanoTime();
                Map<String, TencentStockRealtimeDetail> stocks = crawler.stockRealtimeDetailCN(type);
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
    void stockCaptialFlowCN() {
        for (StockType type : StockType.values()) {
            if (type.isCN()) {
                long start = System.nanoTime();
                Map<String, TencentStockCaptialFlow> stocks = crawler.stockCaptialFlowCN(type);
                long end = System.nanoTime();
                System.out.printf("Stock %s time consuming: %f seconds\n", type, (end - start) / (double) (1000 * 1000 * 1000));
                assertTrue(stocks.size() > 30);
                System.out.printf("Stock %s count: %d\n", type, stocks.size());
                System.out.println(stocks.keySet());
            }
        }
        assertThrows(IllegalArgumentException.class,
                () -> crawler.stockCaptialFlowCN(StockType.HK),
                "Stock type error: " + StockType.HK);
    }

    @Test
    void stockDiskAnalysisCN() {
        for (StockType type : StockType.values()) {
            if (type.isCN()) {
                long start = System.nanoTime();
                Map<String, TencentStockDiskAnalysis> stocks = crawler.stockDiskAnalysisCN(type);
                long end = System.nanoTime();
                System.out.printf("Stock %s time consuming: %f seconds\n", type, (end - start) / (double) (1000 * 1000 * 1000));
                assertTrue(stocks.size() > 30);
                System.out.printf("Stock %s count: %d\n", type, stocks.size());
                System.out.println(stocks.keySet());
            }
        }
        assertThrows(IllegalArgumentException.class,
                () -> crawler.stockDiskAnalysisCN(StockType.HK),
                "Stock type error: " + StockType.HK);
    }

    @Test
    void indexRealtimeSimpleCN() {
        for (IndexType type : IndexType.values()) {
            if (type.isCN()) {
                TencentStockRealtimeSimple index = crawler.indexRealtimeSimpleCN(type);
                assertNotNull(index);
                System.out.printf("Index %s: %s\n", type, index);
            }
        }
    }

    @Test
    void indexRealtimeDetailCN() {
        for (IndexType type : IndexType.values()) {
            if (type.isCN()) {
                TencentStockRealtimeDetail index = crawler.indexRealtimeDetailCN(type);
                assertNotNull(index);
                System.out.printf("Index %s: %s\n", type, index);
            }
        }
    }

    @Test
    void indexRealtimeSimpleCNAll() {
        EnumMap<IndexType, TencentStockRealtimeSimple> results = crawler.indexRealtimeSimpleCN();
        assertTrue(results.size() > 5);
        System.out.println(results);
    }

    @Test
    void indexRealtimeDetailCNAll() {
        EnumMap<IndexType, TencentStockRealtimeDetail> results = crawler.indexRealtimeDetailCN();
        assertTrue(results.size() > 5);
        System.out.println(results);
    }

    @Test
    void stockKLineLatest() {
        for (Map.Entry<String, String> stock : stockExamples.entrySet()) {
            for (KLineType type : KLineType.values()) {
                List<TencentStockKLine> kLineData = crawler.stockKLineLatest(stock.getKey(), type);
                assertTrue(kLineData.size() == 100);
                System.out.printf("%s,%s one %s kline data: %s\n", stock.getKey(), stock.getValue(),
                        type.name().toLowerCase(), kLineData.get(0));
            }
            System.out.println("");
        }
        List<TencentStockKLine> kLineData = crawler.stockKLineLatest("abc", KLineType.DAILY);
        assertNull(kLineData);
        assertThrows(IllegalArgumentException.class,
                () -> crawler.stockKLineLatest("", null),
                "Argument codeSymbol or kType cannot be null!");
    }

    @Test
    void stockKLineDailyForYear() {
        for (Map.Entry<String, String> stock : stockExamples.entrySet()) {
            List<TencentStockKLine> kLineData = crawler.stockKLineDailyForYear(stock.getKey(), Year.of(2017));
            assertTrue(kLineData.size() > 200);
            System.out.printf("%s,%s one daily kline data for year 2017: %s\n", stock.getKey(), stock.getValue(),
                    kLineData.get(0));
            System.out.println("");
        }
        List<TencentStockKLine> kLineData = crawler.stockKLineDailyForYear("sh600887", null);
        assertTrue(kLineData.size() > 20);
        kLineData = crawler.stockKLineDailyForYear("abc", null);
        assertNull(kLineData);
        assertThrows(IllegalArgumentException.class,
                () -> crawler.stockKLineDailyForYear(null, null),
                "Argument codeSymbol cannot be empty!");
    }

    @Test
    void stockMinuteLineLatest() {
        for (Map.Entry<String, String> stock : stockExamples.entrySet()) {
            List<TencentStockMinuteLine> minuteLineData = crawler.stockMinuteLineLatest(stock.getKey());
            assertTrue(minuteLineData.size() > 200);
            System.out.printf("%s,%s one latest minute line data: %s\n", stock.getKey(), stock.getValue(),
                    minuteLineData.get(0));
            System.out.println("");
        }
        List<TencentStockMinuteLine> minuteLineData = crawler.stockMinuteLineLatest("abc");
        assertNull(minuteLineData);
        assertThrows(IllegalArgumentException.class,
                () -> crawler.stockMinuteLineLatest(""),
                "Argument codeSymbol cannot be empty!");
    }

}