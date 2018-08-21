package com.persian.data.em;

import java.io.Serializable;

/**
 * @author: dave01.zhou  Time: 2018/8/3 11:07
 */
public class EmStockUnlock implements Serializable, Cloneable {
    private String unknown1;
    private String code;
    private String unknown2;
    private String nameCn;

    private String date;               // yyyy-MM-dd
    private String unlockCount;        // 解禁数量（股数）
    private String unlockRatio;        // 占总盘比率（unlockCount/total）

    private String close;              // 最近收盘价
    private String unlockValue;        // 解禁市值（元）
    private String total;              // 总股本（股数）
    private String unknown3;
    private String totalDuplicate;
    private String unknown4;           // total-unknown3

    public String getUnknown1() {
        return unknown1;
    }

    public void setUnknown1(String unknown1) {
        this.unknown1 = unknown1;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUnknown2() {
        return unknown2;
    }

    public void setUnknown2(String unknown2) {
        this.unknown2 = unknown2;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUnlockCount() {
        return unlockCount;
    }

    public void setUnlockCount(String unlockCount) {
        this.unlockCount = unlockCount;
    }

    public String getUnlockRatio() {
        return unlockRatio;
    }

    public void setUnlockRatio(String unlockRatio) {
        this.unlockRatio = unlockRatio;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getUnlockValue() {
        return unlockValue;
    }

    public void setUnlockValue(String unlockValue) {
        this.unlockValue = unlockValue;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getUnknown3() {
        return unknown3;
    }

    public void setUnknown3(String unknown3) {
        this.unknown3 = unknown3;
    }

    public String getTotalDuplicate() {
        return totalDuplicate;
    }

    public void setTotalDuplicate(String totalDuplicate) {
        this.totalDuplicate = totalDuplicate;
    }

    public String getUnknown4() {
        return unknown4;
    }

    public void setUnknown4(String unknown4) {
        this.unknown4 = unknown4;
    }

    @Override
    public String toString() {
        return "EmStockUnlock{" +
                "unknown1='" + unknown1 + '\'' +
                ", code='" + code + '\'' +
                ", unknown2='" + unknown2 + '\'' +
                ", nameCn='" + nameCn + '\'' +
                ", date='" + date + '\'' +
                ", unlockCount='" + unlockCount + '\'' +
                ", unlockRatio='" + unlockRatio + '\'' +
                ", close='" + close + '\'' +
                ", unlockValue='" + unlockValue + '\'' +
                ", total='" + total + '\'' +
                ", unknown3='" + unknown3 + '\'' +
                ", totalDuplicate='" + totalDuplicate + '\'' +
                ", unknown4='" + unknown4 + '\'' +
                '}';
    }
}
