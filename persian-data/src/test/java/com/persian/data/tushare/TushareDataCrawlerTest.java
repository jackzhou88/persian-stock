package com.persian.data.tushare;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * @author: dave01.zhou  Time: 2018/8/13 16:28
 */
class TushareDataCrawlerTest {
    private TushareDataCrawler crawler = new TushareDataCrawler();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void stockBasicInfo() {
        List<TushareStockBasicInfo> results1 = crawler.stockBasicInfo();
        assertNotNull(results1);
        assertTrue(results1.size() > 100);
        System.out.printf("One stock basic info: %s\n\n", results1.get(0));

        List<TushareStockRealtime> results2 = crawler.stockcRealtime();
        assertNotNull(results2);
        assertTrue(results2.size() > 100);
        System.out.printf("One stock realtime info: %s\n\n", results2.get(0));

        List<TushareStockPledgeSimple> results3 = crawler.stockPledgeSimple();
        assertNotNull(results3);
        assertTrue(results3.size() > 10);
        System.out.printf("One stock pledge simple info: %s\n\n", results3.get(0));

        List<TushareStockPledgeDetail> results4 = crawler.stockPledgeDetail();
        assertNotNull(results4);
        assertTrue(results4.size() > 10);
        System.out.printf("One stock pledge detail info: %s\n\n", results4.get(0));

        List<TushareStockIssuance> results5 = crawler.stockIssuance();
        assertNotNull(results5);
        assertTrue(results5.size() > 10);
        System.out.printf("One stock issuance info: %s\n\n", results5.get(0));

        List<TushareStockIndustryClassified> results6 = crawler.stockIndustryClassified();
        assertNotNull(results6);
        assertTrue(results6.size() > 10);
        System.out.printf("One stock industry info: %s\n\n", results6.get(0));

        List<TushareStockTradeCalendar> results7 = crawler.stockTradeCalendar();
        assertNotNull(results7);
        assertTrue(results7.size() > 10);
        System.out.printf("One stock trade calendar info: %s\n\n", results7.get(0));
    }

}