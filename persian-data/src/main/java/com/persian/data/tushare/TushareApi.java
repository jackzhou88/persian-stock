package com.persian.data.tushare;

/**
 * @author: dave01.zhou  Time: 2018/8/1 16:09
 */
public class TushareApi {
    // 股票代码列表
    public static final String STOCK_LIST = "http://file.tushare.org/tsdata/symbols.csv";
    // 沪深股票基本信息
    public static final String BASIC_DATA = "http://file.tushare.org/tsdata/all.csv";
    // 当天收盘行情数据
    public static final String HQ_DATA = "http://file.tushare.org/tsdata/h/hq.csv";

    // 股票质押数据
    public static final String PLEDGED_DATA = "http://file.tushare.org/tsdata/gpzy/gpzy.csv";
    // 股票质押详情数据
    public static final String PLEDGED_DATA_DETAIL = "http://file.tushare.org/tsdata/gpzy/gpzy_detail.csv";
    // 股票增发数据
    public static final String ISSUANCE_DATA = "http://file.tushare.org/tsdata/zf.csv";

    // 股票申万行业分类信息
    public static final String INDUSTRY_CLASS_SW = "http://file.tushare.org/tsdata/industry/industry_sw.csv";
    // 股票新浪行业分类信息
    public static final String INDUSTRY_CLASS_SINA = "http://file.tushare.org/tsdata/industry/industry.csv";
    // 股票概念分类信息
    public static final String CONCEPT_CLASS = "http://file.tushare.org/tsdata/industry/concept.csv";

    // 交易日历：isOpen=1是交易日，isOpen=0为休市
    public static final String TRADE_CALENDAR = "http://file.tushare.org/tsdata/calAll.csv";
}
