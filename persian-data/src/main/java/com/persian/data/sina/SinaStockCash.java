package com.persian.data.sina;

import java.io.Serializable;

/**
 * 财务报表：现金流量表
 *
 * @author: dave01.zhou  Time: 2018/8/5 11:30
 */
public class SinaStockCash implements Serializable, Cloneable {
    private String code;         // 股票代码
    private String quarter;      // 季度，yyyyMMdd

    private String jyhd;        // 经营活动现金流量净额（元）
    private String tzhd;        // 投资活动现金流量净额（元）
    private String czhd;        // 筹资活动现金流量净额（元）

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public String getJyhd() {
        return jyhd;
    }

    public void setJyhd(String jyhd) {
        this.jyhd = jyhd;
    }

    public String getTzhd() {
        return tzhd;
    }

    public void setTzhd(String tzhd) {
        this.tzhd = tzhd;
    }

    public String getCzhd() {
        return czhd;
    }

    public void setCzhd(String czhd) {
        this.czhd = czhd;
    }

    @Override
    public String toString() {
        return "SinaStockCash{" +
                "code='" + code + '\'' +
                ", quarter='" + quarter + '\'' +
                ", jyhd='" + jyhd + '\'' +
                ", tzhd='" + tzhd + '\'' +
                ", czhd='" + czhd + '\'' +
                '}';
    }
}
