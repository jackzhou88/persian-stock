package com.persian.data.sina;

import com.persian.data.IndexType;
import com.persian.data.StockType;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author: dave01.zhou  Time: 2018/7/26 16:08
 */
public class SinaDataCrawlerTest {
    private SinaDataCrawler crawler = new SinaDataCrawler();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void stockRealtimeSimpleCN() throws Exception {
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
                Map<String, SinaStockRealtimeDetail> stocks = crawler.stockRealtimeDetailCN(type);
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
    public void stockFinancialInfoCN() throws Exception {
        for (StockType type : StockType.values()) {
            if (type.isCN()) {
                long start = System.nanoTime();
                Map<String, SinaStockFinancialInfo> stocks = crawler.stockFinancialInfoCN(type);
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
                SinaStockRealtimeSimple index = crawler.indexRealtimeSimpleCN(type);
                assertNotNull(index);
                System.out.printf("Index %s: %s\n", type, index);
            }
        }
    }

    @Test
    public void indexRealtimeDetailCN() throws Exception {
        for (IndexType type : IndexType.values()) {
            if (type.isCN()) {
                SinaStockRealtimeDetail index = crawler.indexRealtimeDetailCN(type);
                assertNotNull(index);
                System.out.printf("Index %s: %s\n", type, index);
            }
        }
    }

}