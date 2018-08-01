package com.persian.data.sina;

import java.io.Serializable;

/**
 * @author: dave01.zhou  Time: 2018/7/29 18:09
 */
public class SinaStockRealtimeSimple implements Serializable, Cloneable {
    // 注意：字段定义顺序必须与数据中各字段值顺序保持一致，末尾可以定义额外的数据中不存在的字段

    private String nameCn;

    private String latest;
    private String change;
    private String changePercent;
    private String volume;              // 成交量（单位：万股数）
    private String amount;              // 成交金额（单位：万元）

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getLatest() {
        return latest;
    }

    public void setLatest(String latest) {
        this.latest = latest;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(String changePercent) {
        this.changePercent = changePercent;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "SinaStockRealtimeSimple{" +
                "nameCn='" + nameCn + '\'' +
                ", latest='" + latest + '\'' +
                ", change='" + change + '\'' +
                ", changePercent='" + changePercent + '\'' +
                ", volume='" + volume + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
