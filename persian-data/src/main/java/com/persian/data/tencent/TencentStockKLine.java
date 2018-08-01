package com.persian.data.tencent;

import java.io.Serializable;

/**
 * @author: dave01.zhou  Time: 2018/7/30 22:45
 */
public class TencentStockKLine implements Serializable, Cloneable {
    private String date;        // yyMMdd
    private String open;
    private String close;
    private String high;
    private String low;
    private String volume;     // 成交量，股数

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "TencentStockKLine{" +
                "date='" + date + '\'' +
                ", open='" + open + '\'' +
                ", close='" + close + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", volume='" + volume + '\'' +
                '}';
    }
}
