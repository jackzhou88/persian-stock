package com.persian.data.sina;

import java.io.Serializable;

/**
 * @author: dave01.zhou  Time: 2018/7/25 15:06
 */
public class SinaHKStockModel implements Serializable, Cloneable {
    // sample data:
    // rt_hk01988=MINSHENG BANK,
    // 民生银行,
    // 5.850,
    // 5.840,
    // 5.860,
    // 5.800,
    // 5.810,
    // -0.030,
    // -0.514,
    // 5.800,
    // 5.810,
    // 74973013.620,
    // 12892202,
    // 3.668,
    // 3.614,
    // 9.350,
    // 5.390,
    // 2018/07/25,
    // 15:53:00,
    // 2|3,
    // N|Y|Y,
    // 0.000|0.000|0.000,
    // 0|||0.000|0.000|0.000,
    // |0,
    // Y

    private long id;
    private String nameEn;
    private String nameCh;
    private double open;
    private double close;
    private double high;
    private double low;
    private double lastest;
    private double change;
    private double changePercent;
    private double ask;
    private double bid;
}
