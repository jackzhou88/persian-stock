package com.persian.data.sina;

/**
 * @author: dave01.zhou  Time: 2018/7/25 14:39
 */
public class SinaApi {
    public static String STOCK_DETAIL = "http://hq.sinajs.cn/format=text&list=";
    public static String STOCK_BRIEF = "http://hq.sinajs.cn/format=text&list=s_";
    public static String STOCK_KLINE_DAILY = "http://image.sinajs.cn/newchart/daily/n/";
    public static String STOCK_KLINE_WEEKLY = "http://image.sinajs.cn/newchart/weekly/n/";
    public static String STOCK_KLINE_MONTHLY = "http://image.sinajs.cn/newchart/monthly/n/";
    public static long STOCK_SH_ID_MIN = 600000L;
    public static long STOCK_SH_ID_MAX = 699999L;

    public static String STOCK_SZ_DETAIL = "http://hq.sinajs.cn/format=text&list=sz";
    public static String STOCK_SZ_BRIEF = "http://hq.sinajs.cn/format=text&list=s_sz";
}
