package com.persian.data.tushare;

import java.io.Serializable;

/**
 * @author: dave01.zhou  Time: 2018/8/9 16:44
 */
public class TushareStockPledgeSimple implements Serializable, Cloneable {
    private String code;
    private String name;
    private String deals;                // 质押次数
    private String unrest_pledged;       // 无限售股质押数量(万)
    private String rest_pledged;         // 限售股质押数量(万)
    private String totals;               // 总股本
    private String p_ratio;              // 质押比例（%）

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

    public String getDeals() {
        return deals;
    }

    public void setDeals(String deals) {
        this.deals = deals;
    }

    public String getUnrest_pledged() {
        return unrest_pledged;
    }

    public void setUnrest_pledged(String unrest_pledged) {
        this.unrest_pledged = unrest_pledged;
    }

    public String getRest_pledged() {
        return rest_pledged;
    }

    public void setRest_pledged(String rest_pledged) {
        this.rest_pledged = rest_pledged;
    }

    public String getTotals() {
        return totals;
    }

    public void setTotals(String totals) {
        this.totals = totals;
    }

    public String getP_ratio() {
        return p_ratio;
    }

    public void setP_ratio(String p_ratio) {
        this.p_ratio = p_ratio;
    }

    @Override
    public String toString() {
        return "TushareStockPledge{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", deals='" + deals + '\'' +
                ", unrest_pledged='" + unrest_pledged + '\'' +
                ", rest_pledged='" + rest_pledged + '\'' +
                ", totals='" + totals + '\'' +
                ", p_ratio='" + p_ratio + '\'' +
                '}';
    }
}
