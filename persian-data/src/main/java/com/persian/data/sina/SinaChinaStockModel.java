package com.persian.data.sina;

import java.io.Serializable;

/**
 * @author: dave01.zhou  Time: 2018/7/25 12:58
 */
public class SinaChinaStockModel implements Serializable, Cloneable {
    // sample data:
    // sh600887=伊利股份,
    // 28.080,
    // 28.020,
    // 27.420,
    // 28.100,
    // 27.390,
    // 27.410,
    // 27.420,
    // 37152371,
    // 1029132731.000,
    // 48996,
    // 27.410,
    // 159144,
    // 27.400,
    // 98206,
    // 27.390,
    // 136200,
    // 27.380,
    // 48100,
    // 27.370,
    // 14300,
    // 27.420,
    // 28700,
    // 27.430,
    // 63887,
    // 27.440,
    // 1100,
    // 27.450,
    // 4500,
    // 27.460,
    // 2018-07-25,
    // 13:14:39,
    // 00

    private long id;
    private String name;
    private double open;
    private double close;
    private double lastest;
    private double high;
    private double low;
    private double change;
    private double changePercent;
    private double bid;
    private double ask;
    private long volume;
    private double amount;
    private int bid1Volume;
    private double bid1;
    private long bid2Volume;
    private double bid2;
    private long bid3Volume;
    private double bid3;
    private long bid4Volume;
    private double bid4;
    private long bid5Volume;
    private double bid5;
    private long ask1Volume;
    private double ask1;
    private long ask2Volume;
    private double ask2;
    private long ask3Volume;
    private double ask3;
    private long ask4Volume;
    private double ask4;
    private long ask5Volume;
    private double ask5;
    private String date;
    private String time;
    private int state;
}
