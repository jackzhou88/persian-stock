package com.persian.data.sina;

import java.io.Serializable;

/**
 * @author: dave01.zhou  Time: 2018/7/29 18:32
 */
public class SinaStockBasicInfo implements Serializable, Cloneable {
    private String type;
    private String nameEn;

    private String epsPreYear;               // Earnings Per Share, 每股收益（利润）
    private String epsTTM;                   // EPS of Trailing Twelve Months, 滚动EPS
    private String epsLatest;                // 今年迄今为止的每股收益
    private String bvps;                     // Book Value Per Share, 每股净资产
    private String ma5AvgVolumePerMinute;    // 过去5个交易日平均每分钟成交量

    private String total;                    // 总股本
    private String circulation;              // 流通股本
    private String circulationA;             // 流通A股
    private String circulationB;             // 流通B股
    private String currencyUnit;             // 货币单位(CNY,US,HK)

    private String profitPreYear;            // 最近年度净利润（单位：亿元）
    private String profitTTM;                // 最近4个季度净利润（单位：亿元）
    private String issuePrice;               // 发行价
    private String state;                    // 状态（0无该记录, 1上市正常交易, 2未上市, 3退市）

    private String roeLatest;                // 最近一个报告期净资产收益率(%)
    private String incomeLatest;             // 最近一个报告期主营收入（亿元）
    private String profitLatest;             // 最近一个报告期净利润（亿元）
    private String unknown1;
    private String unknown2;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getEpsPreYear() {
        return epsPreYear;
    }

    public void setEpsPreYear(String epsPreYear) {
        this.epsPreYear = epsPreYear;
    }

    public String getEpsTTM() {
        return epsTTM;
    }

    public void setEpsTTM(String epsTTM) {
        this.epsTTM = epsTTM;
    }

    public String getEpsLatest() {
        return epsLatest;
    }

    public void setEpsLatest(String epsLatest) {
        this.epsLatest = epsLatest;
    }

    public String getBvps() {
        return bvps;
    }

    public void setBvps(String bvps) {
        this.bvps = bvps;
    }

    public String getMa5AvgVolumePerMinute() {
        return ma5AvgVolumePerMinute;
    }

    public void setMa5AvgVolumePerMinute(String ma5AvgVolumePerMinute) {
        this.ma5AvgVolumePerMinute = ma5AvgVolumePerMinute;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCirculation() {
        return circulation;
    }

    public void setCirculation(String circulation) {
        this.circulation = circulation;
    }

    public String getCirculationA() {
        return circulationA;
    }

    public void setCirculationA(String circulationA) {
        this.circulationA = circulationA;
    }

    public String getCirculationB() {
        return circulationB;
    }

    public void setCirculationB(String circulationB) {
        this.circulationB = circulationB;
    }

    public String getCurrencyUnit() {
        return currencyUnit;
    }

    public void setCurrencyUnit(String currencyUnit) {
        this.currencyUnit = currencyUnit;
    }

    public String getProfitPreYear() {
        return profitPreYear;
    }

    public void setProfitPreYear(String profitPreYear) {
        this.profitPreYear = profitPreYear;
    }

    public String getProfitTTM() {
        return profitTTM;
    }

    public void setProfitTTM(String profitTTM) {
        this.profitTTM = profitTTM;
    }

    public String getIssuePrice() {
        return issuePrice;
    }

    public void setIssuePrice(String issuePrice) {
        this.issuePrice = issuePrice;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRoeLatest() {
        return roeLatest;
    }

    public void setRoeLatest(String roeLatest) {
        this.roeLatest = roeLatest;
    }

    public String getIncomeLatest() {
        return incomeLatest;
    }

    public void setIncomeLatest(String incomeLatest) {
        this.incomeLatest = incomeLatest;
    }

    public String getProfitLatest() {
        return profitLatest;
    }

    public void setProfitLatest(String profitLatest) {
        this.profitLatest = profitLatest;
    }

    public String getUnknown1() {
        return unknown1;
    }

    public void setUnknown1(String unknown1) {
        this.unknown1 = unknown1;
    }

    public String getUnknown2() {
        return unknown2;
    }

    public void setUnknown2(String unknown2) {
        this.unknown2 = unknown2;
    }
}
