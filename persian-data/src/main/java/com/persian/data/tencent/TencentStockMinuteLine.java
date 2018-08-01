package com.persian.data.tencent;

import java.io.Serializable;

/**
 * @author: dave01.zhou  Time: 2018/7/31 14:21
 */
public class TencentStockMinuteLine implements Serializable, Cloneable {
    private String time;        // 分钟时间，格式HHmm
    private String latest;      // 当前股价
    private String volume;      // 到目前为止的成交量，股数

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLatest() {
        return latest;
    }

    public void setLatest(String latest) {
        this.latest = latest;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "TencentStockMinuteLine{" +
                "time='" + time + '\'' +
                ", latest='" + latest + '\'' +
                ", volume='" + volume + '\'' +
                '}';
    }
}
