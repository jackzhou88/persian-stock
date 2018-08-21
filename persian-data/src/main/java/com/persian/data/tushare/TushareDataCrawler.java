package com.persian.data.tushare;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.persian.data.DataCrawler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

/**
 * @author: dave01.zhou  Time: 2018/8/5 22:22
 */
public class TushareDataCrawler extends DataCrawler {
    private static final Logger logger = LoggerFactory.getLogger(TushareDataCrawler.class);

    private <T> List<T> queryData(String url, Class<T> pojoClass) {
        CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();
        ObjectReader dataReader = csvMapper.readerFor(pojoClass).with(csvSchema);
        return commonDownloadSync(url, is -> {
            try {
                MappingIterator<T> iter = (pojoClass == TushareStockBasicInfo.class ?
                        dataReader.readValues(new InputStreamReader(is, "gb2312")) : dataReader.readValues(is));
                List<T> results = iter.readAll();
                return results;
            } catch (Exception e) {
                logger.error("Parsing error for stock data", e);
            }
            return Collections.emptyList();
        });
    }

    public List<TushareStockBasicInfo> stockBasicInfo() {
        return queryData(TushareApi.BASIC_DATA, TushareStockBasicInfo.class);
    }

    public List<TushareStockRealtime> stockcRealtime() {
        return queryData(TushareApi.HQ_DATA, TushareStockRealtime.class);
    }

    public List<TushareStockPledgeSimple> stockPledgeSimple() {
        return queryData(TushareApi.PLEDGED_DATA, TushareStockPledgeSimple.class);
    }

    public List<TushareStockPledgeDetail> stockPledgeDetail() {
        return queryData(TushareApi.PLEDGED_DATA_DETAIL, TushareStockPledgeDetail.class);
    }

    public List<TushareStockIssuance> stockIssuance() {
        return queryData(TushareApi.ISSUANCE_DATA, TushareStockIssuance.class);
    }

    public List<TushareStockIndustryClassified> stockIndustryClassified() {
        return queryData(TushareApi.INDUSTRY_CLASS_SW, TushareStockIndustryClassified.class);
    }

    public List<TushareStockTradeCalendar> stockTradeCalendar() {
        return queryData(TushareApi.TRADE_CALENDAR, TushareStockTradeCalendar.class);
    }
}
