package com.persian.data.sina;

import java.io.Serializable;

/**
 * @author: dave01.zhou  Time: 2018/8/5 10:05
 */
public class SinaStockMinuteLine implements Serializable, Cloneable {
    private String day;        // yyyy-MM-dd HH:mm:ss
    private String open;
    private String high;
    private String low;
    private String close;
    private String volume;    // 成交量（股数）

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
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

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "SinaStockMinuteLine{" +
                "day='" + day + '\'' +
                ", open='" + open + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", close='" + close + '\'' +
                ", volume='" + volume + '\'' +
                '}';
    }
}
