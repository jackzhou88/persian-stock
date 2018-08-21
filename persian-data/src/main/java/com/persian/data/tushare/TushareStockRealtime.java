package com.persian.data.tushare;

import java.io.Serializable;

/**
 * @author: dave01.zhou  Time: 2018/8/6 14:15
 */
public class TushareStockRealtime implements Serializable, Cloneable {
    private String code;
    private String name;
    private String p_change;          // 涨幅%
    private String price;
    private String change;
    private String open;
    private String high;
    private String low;
    private String preprice;          // 昨收
    private String pe;
    private String volratio;          // 量比
    private String turnover;          // 换手率%
    private String range;             // 振幅%
    private String volume;            // 成交总量
    private String selling;           // 内盘
    private String buying;            // 外盘
    private String amount;            // 成交总金额
    private String totals;            // 总股本(万)
    private String industry;          // 细分行业
    private String area;
    private String floats;            // 流通股本(万)
    private String fvalues;           // 流通市值
    private String abvalues;          // AB股总市值
    private String avgprice;          // 均价
    private String strength;          // 强弱度%
    private String activity;          // 活跃度
    private String avgturnover;       // 平均换手
    private String attack;            // 攻击波%
    private String interval3;         // 近3月涨幅
    private String interval6;         // 近6月涨幅

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

    public String getP_change() {
        return p_change;
    }

    public void setP_change(String p_change) {
        this.p_change = p_change;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
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

    public String getPreprice() {
        return preprice;
    }

    public void setPreprice(String preprice) {
        this.preprice = preprice;
    }

    public String getPe() {
        return pe;
    }

    public void setPe(String pe) {
        this.pe = pe;
    }

    public String getVolratio() {
        return volratio;
    }

    public void setVolratio(String volratio) {
        this.volratio = volratio;
    }

    public String getTurnover() {
        return turnover;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getSelling() {
        return selling;
    }

    public void setSelling(String selling) {
        this.selling = selling;
    }

    public String getBuying() {
        return buying;
    }

    public void setBuying(String buying) {
        this.buying = buying;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTotals() {
        return totals;
    }

    public void setTotals(String totals) {
        this.totals = totals;
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

    public String getFloats() {
        return floats;
    }

    public void setFloats(String floats) {
        this.floats = floats;
    }

    public String getFvalues() {
        return fvalues;
    }

    public void setFvalues(String fvalues) {
        this.fvalues = fvalues;
    }

    public String getAbvalues() {
        return abvalues;
    }

    public void setAbvalues(String abvalues) {
        this.abvalues = abvalues;
    }

    public String getAvgprice() {
        return avgprice;
    }

    public void setAvgprice(String avgprice) {
        this.avgprice = avgprice;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getAvgturnover() {
        return avgturnover;
    }

    public void setAvgturnover(String avgturnover) {
        this.avgturnover = avgturnover;
    }

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    public String getInterval3() {
        return interval3;
    }

    public void setInterval3(String interval3) {
        this.interval3 = interval3;
    }

    public String getInterval6() {
        return interval6;
    }

    public void setInterval6(String interval6) {
        this.interval6 = interval6;
    }

    @Override
    public String toString() {
        return "TushareStockRealtime{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", p_change='" + p_change + '\'' +
                ", price='" + price + '\'' +
                ", change='" + change + '\'' +
                ", open='" + open + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", preprice='" + preprice + '\'' +
                ", pe='" + pe + '\'' +
                ", volratio='" + volratio + '\'' +
                ", turnover='" + turnover + '\'' +
                ", range='" + range + '\'' +
                ", volume='" + volume + '\'' +
                ", selling='" + selling + '\'' +
                ", buying='" + buying + '\'' +
                ", amount='" + amount + '\'' +
                ", totals='" + totals + '\'' +
                ", industry='" + industry + '\'' +
                ", area='" + area + '\'' +
                ", floats='" + floats + '\'' +
                ", fvalues='" + fvalues + '\'' +
                ", abvalues='" + abvalues + '\'' +
                ", avgprice='" + avgprice + '\'' +
                ", strength='" + strength + '\'' +
                ", activity='" + activity + '\'' +
                ", avgturnover='" + avgturnover + '\'' +
                ", attack='" + attack + '\'' +
                ", interval3='" + interval3 + '\'' +
                ", interval6='" + interval6 + '\'' +
                '}';
    }
}
