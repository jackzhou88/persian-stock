package com.persian.data.tencent;

import com.persian.data.IndexType;
import com.persian.data.KLineType;
import com.persian.data.StockType;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author: dave01.zhou  Time: 2018/7/28 19:38
 */
public class TencentDataCrawlerTest {
    private TencentDataCrawler crawler = new TencentDataCrawler();
    private Map<String, String> stockExamples = new LinkedHashMap<>();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        stockExamples.put("sh600887", "伊利股份");
        stockExamples.put("sh900905", "老凤祥B");
        stockExamples.put("sz000858", "五粮液");
        stockExamples.put("sz200596", "古井贡B");
        stockExamples.put("sz300003", "乐普医疗");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void stockRealtimeSimpleCN() throws Exception {
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
            if (type == StockType.HK) {
                thrown.expect(IllegalArgumentException.class);
                thrown.expectMessage("Stock type error: " + StockType.HK);
                crawler.stockRealtimeSimpleCN(StockType.HK);
            }
        }
    }

    @Test
    public void stockRealtimeDetailCN() throws Exception {
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
            if (type == StockType.HK) {
                thrown.expect(IllegalArgumentException.class);
                thrown.expectMessage("Stock type error: " + StockType.HK);
                crawler.stockRealtimeSimpleCN(StockType.HK);
            }
        }
    }

    @Test
    public void stockCaptialFlowCN() throws Exception {
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
            if (type == StockType.HK) {
                thrown.expect(IllegalArgumentException.class);
                thrown.expectMessage("Stock type error: " + StockType.HK);
                crawler.stockRealtimeSimpleCN(StockType.HK);
            }
        }
    }

    @Test
    public void stockDiskAnalysisCN() throws Exception {
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
            if (type == StockType.HK) {
                thrown.expect(IllegalArgumentException.class);
                thrown.expectMessage("Stock type error: " + StockType.HK);
                crawler.stockRealtimeSimpleCN(StockType.HK);
            }
        }
    }

    @Test
    public void indexRealtimeSimpleCN() throws Exception {
        for (IndexType type : IndexType.values()) {
            if (type.isCN()) {
                TencentStockRealtimeSimple index = crawler.indexRealtimeSimpleCN(type);
                assertNotNull(index);
                System.out.printf("Index %s: %s\n", type, index);
            }
        }
    }

    @Test
    public void indexRealtimeDetailCN() throws Exception {
        for (IndexType type : IndexType.values()) {
            if (type.isCN()) {
                TencentStockRealtimeDetail index = crawler.indexRealtimeDetailCN(type);
                assertNotNull(index);
                System.out.printf("Index %s: %s\n", type, index);
            }
        }
    }

    @Test
    public void stockKLineLatest() throws Exception {
        for (Map.Entry<String, String> stock : stockExamples.entrySet()) {
            for (KLineType type : KLineType.values()) {
                List<TencentStockKLine> kLineData = crawler.stockKLineLatest(stock.getKey(), type);
                assertTrue(kLineData.size() == 100);
                System.out.printf("%s,%s one %s kline data: %s\n", stock.getKey(), stock.getValue(),
                        type.name().toLowerCase(), kLineData.get(0));
            }
            System.out.println("");
        }
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Argument codeSymbol or kType cannot be null!");
        crawler.stockKLineLatest("", null);
    }

    @Test
    public void stockKLineDailyForYear() throws Exception {
        for (Map.Entry<String, String> stock : stockExamples.entrySet()) {
            List<TencentStockKLine> kLineData = crawler.stockKLineDailyForYear(stock.getKey(), "17");
            assertTrue(kLineData.size() > 200);
            System.out.printf("%s,%s one daily kline data for year 17: %s\n", stock.getKey(), stock.getValue(),
                    kLineData.get(0));
            System.out.println("");
        }
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Argument year error!");
        crawler.stockKLineDailyForYear("sh600887", "2018");
    }

    @Test
    public void stockMinuteLineLatest() throws Exception {
        for (Map.Entry<String, String> stock : stockExamples.entrySet()) {
            List<TencentStockMinuteLine> minuteLineData = crawler.stockMinuteLineLatest(stock.getKey());
            assertTrue(minuteLineData.size() > 200);
            System.out.printf("%s,%s one latest minute line data: %s\n", stock.getKey(), stock.getValue(),
                    minuteLineData.get(0));
            System.out.println("");
        }
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Argument codeSymbol cannot be empty!");
        crawler.stockMinuteLineLatest("");
    }

}