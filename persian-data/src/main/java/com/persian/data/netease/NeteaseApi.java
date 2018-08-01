package com.persian.data.netease;

/**
 * @author: dave01.zhou  Time: 2018/7/28 1:54
 */
public class NeteaseApi {
    // 实时行情数据数据订阅接口
    public static final String MONEY_FEED = "http://api.money.126.net/data/feed/%s";

    // 历史数据：日K线数据（csv格式）
    public static final String KLINE_DAILY = "http://quotes.money.163.com/service/chddata.html?code=%s";
}
