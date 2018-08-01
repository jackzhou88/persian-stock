package com.persian.data.ifeng;

/**
 * @author: dave01.zhou  Time: 2018/7/26 0:53
 */
public class IfengApi {
    // 实时行情数据：JSON格式
    public static final String HQ_SERVICE = "https://hq.finance.ifeng.com/q.php?l=%s";

    // K线数据：JSON格式，参数为K线类型（daily, weekly, monthly），股票代码
    public static String KLINE_LATEST = "http://api.finance.ifeng.com/ak%s/?type=last&code=%s";

    // 分时数据：参数为分钟类型（5,15,30,60），股票代码
    public static String MINUTE_LINE_LATEST = "http://api.finance.ifeng.com/akmin/?type=%s&scode=%s";
}
