package com.persian.data.tushare;

import java.io.Serializable;

/**
 * @author: dave01.zhou  Time: 2018/8/5 22:33
 */
public class TushareStockBasicInfo implements Serializable, Cloneable {
    private String code;
    private String name;
    private String industry;
    private String area;

    private String pe;
    private String outstanding;        // 流通股本（亿）
    private String totals;             // 总股本（亿）
    private String totalAssets;
    private String liquidAssets;
    private String fixedAssets;
    private String reserved;                // 公积金
    private String reservedPerShare;        // 每股公积金
    private String esp;                     // 每股收益
    private String bvps;                    // 每股净资产
    private String pb;
    private String timeToMarket;            // 上市日期
    private String undp;                    // 未分配利润
    private String perundp;                 // 每股未分配利润
    private String rev;                     // 收入同比(%)
    private String profit;                  // 利润同比(%)
    private String gpr;                     // 毛利率(%)
    private String npr;                     // 净利润率(%)
    private String holders;                 // 股东人数

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPe() {
        return pe;
    }

    public void setPe(String pe) {
        this.pe = pe;
    }

    public String getOutstanding() {
        return outstanding;
    }

    public void setOutstanding(String outstanding) {
        this.outstanding = outstanding;
    }

    public String getTotals() {
        return totals;
    }

    public void setTotals(String totals) {
        this.totals = totals;
    }

    public String getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(String totalAssets) {
        this.totalAssets = totalAssets;
    }

    public String getLiquidAssets() {
        return liquidAssets;
    }

    public void setLiquidAssets(String liquidAssets) {
        this.liquidAssets = liquidAssets;
    }

    public String getFixedAssets() {
        return fixedAssets;
    }

    public void setFixedAssets(String fixedAssets) {
        this.fixedAssets = fixedAssets;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }

    public String getReservedPerShare() {
        return reservedPerShare;
    }

    public void setReservedPerShare(String reservedPerShare) {
        this.reservedPerShare = reservedPerShare;
    }

    public String getEsp() {
        return esp;
    }

    public void setEsp(String esp) {
        this.esp = esp;
    }

    public String getBvps() {
        return bvps;
    }

    public void setBvps(String bvps) {
        this.bvps = bvps;
    }

    public String getPb() {
        return pb;
    }

    public void setPb(String pb) {
        this.pb = pb;
    }

    public String getTimeToMarket() {
        return timeToMarket;
    }

    public void setTimeToMarket(String timeToMarket) {
        this.timeToMarket = timeToMarket;
    }

    public String getUndp() {
        return undp;
    }

    public void setUndp(String undp) {
        this.undp = undp;
    }

    public String getPerundp() {
        return perundp;
    }

    public void setPerundp(String perundp) {
        this.perundp = perundp;
    }

    public String getRev() {
        return rev;
    }

    public void setRev(String rev) {
        this.rev = rev;
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }

    public String getGpr() {
        return gpr;
    }

    public void setGpr(String gpr) {
        this.gpr = gpr;
    }

    public String getNpr() {
        return npr;
    }

    public void setNpr(String npr) {
        this.npr = npr;
    }

    public String getHolders() {
        return holders;
    }

    public void setHolders(String holders) {
        this.holders = holders;
    }

    @Override
    public String toString() {
        return "TushareStockBasicInfo{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", industry='" + industry + '\'' +
                ", area='" + area + '\'' +
                ", pe='" + pe + '\'' +
                ", outstanding='" + outstanding + '\'' +
                ", totals='" + totals + '\'' +
                ", totalAssets='" + totalAssets + '\'' +
                ", liquidAssets='" + liquidAssets + '\'' +
                ", fixedAssets='" + fixedAssets + '\'' +
                ", reserved='" + reserved + '\'' +
                ", reservedPerShare='" + reservedPerShare + '\'' +
                ", esp='" + esp + '\'' +
                ", bvps='" + bvps + '\'' +
                ", pb='" + pb + '\'' +
                ", timeToMarket='" + timeToMarket + '\'' +
                ", undp='" + undp + '\'' +
                ", perundp='" + perundp + '\'' +
                ", rev='" + rev + '\'' +
                ", profit='" + profit + '\'' +
                ", gpr='" + gpr + '\'' +
                ", npr='" + npr + '\'' +
                ", holders='" + holders + '\'' +
                '}';
    }
}
