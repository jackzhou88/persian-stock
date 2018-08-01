package com.persian.data.tencent;

/**
 * @author: dave01.zhou  Time: 2018/7/28 0:18
 */
public class TencentApi {
    // 实时行情数据：财经行情查询接口（CSV格式）
    public static final String QT_SERVICE = "http://qt.gtimg.cn/q=%s";

    // 分时数据：最近1天、5天分时数据
    public static final String MINUTE_LINE_LATEST = "http://data.gtimg.cn/flashdata/hushen/minute/%s.js";
    public static final String MINUTE_LINE_DAY5 = "http://data.gtimg.cn/flashdata/hushen/4day/%s/%s.js";

    // K线数据：参数为K线类型（daily, weekly, monthly），股票代码，最近100条数据
    public static final String KLINE_LATEST = "http://data.gtimg.cn/flashdata/hushen/latest/%s/%s.js";
    // 指定年份的日K线数据
    public static final String KLINE_DAILY_YEAR = "http://data.gtimg.cn/flashdata/hushen/daily/%s/%s.js";
}
