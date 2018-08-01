package com.persian.data.tencent;

import java.io.Serializable;

/**
 * @author: dave01.zhou  Time: 2018/7/28 18:04
 */
public class TencentStockRealtimeSimple implements Serializable, Cloneable {
    private String unknown1;
    private String nameCn;
    private String code;

    private String latest;
    private String change;
    private String changePercent;
    private String volume;                      // 成交量（手）
    private String amount;                      // 成交额（万元）

    private String unknown2;
    private String totalValue;                  // 总市值（亿元）

    public String getUnknown1() {
        return unknown1;
    }

    public void setUnknown1(String unknown1) {
        this.unknown1 = unknown1;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getUnknown2() {
        return unknown2;
    }

    public void setUnknown2(String unknown2) {
        this.unknown2 = unknown2;
    }

    public String getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(String totalValue) {
        this.totalValue = totalValue;
    }

    @Override
    public String toString() {
        return "TencentStockRealtimeSimple{" +
                "unknown1='" + unknown1 + '\'' +
                ", nameCn='" + nameCn + '\'' +
                ", code='" + code + '\'' +
                ", latest='" + latest + '\'' +
                ", change='" + change + '\'' +
                ", changePercent='" + changePercent + '\'' +
                ", volume='" + volume + '\'' +
                ", amount='" + amount + '\'' +
                ", unknown2='" + unknown2 + '\'' +
                ", totalValue='" + totalValue + '\'' +
                '}';
    }
}
