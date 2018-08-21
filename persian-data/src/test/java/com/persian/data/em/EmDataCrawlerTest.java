package com.persian.data.em;

import com.persian.data.IndexType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author: dave01.zhou  Time: 2018/8/13 17:31
 */
class EmDataCrawlerTest {
    private EmDataCrawler crawler = new EmDataCrawler();
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
    void stockCnHkFlow() {
        List<EmStockCnHkFlow> flows = crawler.stockCnHkFlow();
        assertTrue(flows.size() > 50);
        System.out.printf("CnHk flow 1: %s\n", flows.get(0));
        System.out.printf("CnHk flow tail: %s\n", flows.get(flows.size() - 1));
    }

    @Test
    void stockUnlock() {
        Map<String, EmStockUnlock> results = crawler.stockUnlock(LocalDate.now());
        assertTrue(results.size() > 2);
        for (Map.Entry<String, EmStockUnlock> entry : results.entrySet()) {
            System.out.printf("First stock unlock: %s\n", entry.getValue().toString());
            break;
        }
    }

    @Test
    void stockTop10Holders() {
        List<EmStockTop10Holders> results = crawler.stockTop10Holders("sh600887");
        System.out.printf("Results size: %d\n", results.size());
        if (results.size() > 0) {
            System.out.printf("First top 10 holders for 600887: %s\n", results.get(0));
        }
        List<EmStockTop10Holders> results2 = crawler.stockTop10Holders("sz300144");
        if (results2.size() > 0) {
            System.out.printf("First top 10 holders for 300144: %s\n", results2.get(0));
        }
        assertThrows(IllegalArgumentException.class,
                () -> crawler.stockTop10Holders(""),
                "Argument codySymbol cannot be empty!");
    }

    @Test
    void stockForIndexCN() {
        Map<String, EmStockDesc> results = crawler.stockForIndexCN(IndexType.SH_50);
        assertTrue(results.size() == 50);
        System.out.printf("One stock for %s: %s\n", IndexType.SH_50, results.get("600000"));
        results = crawler.stockForIndexCN(IndexType.HS_300);
        assertTrue(results.size() == 300);
        System.out.printf("One stock for %s: %s\n", IndexType.HS_300, results.get("600009"));
        results = crawler.stockForIndexCN(IndexType.ZZ_500);
        assertTrue(results.size() == 500);
        System.out.printf("One stock for %s: %s\n", IndexType.ZZ_500, results.get("600004"));
        assertThrows(IllegalArgumentException.class,
                () -> crawler.stockForIndexCN(IndexType.SZ_SME),
                "Current not support index type: " + IndexType.SZ_SME);
    }

}