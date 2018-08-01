package com.persian.data.sina;

import java.io.Serializable;

/**
 * @author: dave01.zhou  Time: 2018/7/29 18:48
 */
public class SinaStockRealtimeHK implements Serializable, Cloneable {
    private String nameEn;
    private String nameCn;

    private String open;
    private String close;
    private String high;
    private String low;

    private String latest;
    private String change;
    private String changePercent;

    private String ask;                 // 卖1价
    private String bid;                 // 买1价
    private String amount;              // 成交金额（单位：港元）
    private String volume;              // 成交量（单位：股数）

    private String pe;                 // 市盈率
    private String roe;                // 收益率
    private String weeks52High;         // 52周最高价
    private String weeks52Low;          // 52周最低价

    private String date;                // 日期（yyyy/MM/dd）
    private String time;                // 时间（HH:mm:ss）

    private String unknown1;
    private String unknown2;
    private String unknown3;
    private String unknown4;
    private String unknown5;
    private String unknown6;

}
