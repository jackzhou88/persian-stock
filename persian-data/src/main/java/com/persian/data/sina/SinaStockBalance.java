package com.persian.data.sina;

import java.io.Serializable;

/**
 * 财务报表：资产负债表
 *
 * @author: dave01.zhou  Time: 2018/8/5 11:08
 */
public class SinaStockBalance implements Serializable, Cloneable {
    private String code;         // 股票代码
    private String quarter;      // 季度，yyyyMMdd

    private String yspj;         // 应收票据（元）
    private String yszk;         // 应收账款（元）
    private String ldzchj;       // 流动资产合计

    private String gdzj;        // 固定资产
    private String wxzj;        // 无形资产
    private String sy;          // 商誉
    private String fldzchj;     // 非流动资产合计
    private String zchj;        // 资产合计

    private String ldfzhj;      // 流动负债合计
    private String fldfzhj;     // 非流动负债合计
    private String fzhj;        // 负债合计

    private String syzqy;       // 所有者权益

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

    public String getYspj() {
        return yspj;
    }

    public void setYspj(String yspj) {
        this.yspj = yspj;
    }

    public String getYszk() {
        return yszk;
    }

    public void setYszk(String yszk) {
        this.yszk = yszk;
    }

    public String getLdzchj() {
        return ldzchj;
    }

    public void setLdzchj(String ldzchj) {
        this.ldzchj = ldzchj;
    }

    public String getGdzj() {
        return gdzj;
    }

    public void setGdzj(String gdzj) {
        this.gdzj = gdzj;
    }

    public String getWxzj() {
        return wxzj;
    }

    public void setWxzj(String wxzj) {
        this.wxzj = wxzj;
    }

    public String getSy() {
        return sy;
    }

    public void setSy(String sy) {
        this.sy = sy;
    }

    public String getFldzchj() {
        return fldzchj;
    }

    public void setFldzchj(String fldzchj) {
        this.fldzchj = fldzchj;
    }

    public String getZchj() {
        return zchj;
    }

    public void setZchj(String zchj) {
        this.zchj = zchj;
    }

    public String getLdfzhj() {
        return ldfzhj;
    }

    public void setLdfzhj(String ldfzhj) {
        this.ldfzhj = ldfzhj;
    }

    public String getFldfzhj() {
        return fldfzhj;
    }

    public void setFldfzhj(String fldfzhj) {
        this.fldfzhj = fldfzhj;
    }

    public String getFzhj() {
        return fzhj;
    }

    public void setFzhj(String fzhj) {
        this.fzhj = fzhj;
    }

    public String getSyzqy() {
        return syzqy;
    }

    public void setSyzqy(String syzqy) {
        this.syzqy = syzqy;
    }

    @Override
    public String toString() {
        return "SinaStockBalance{" +
                "code='" + code + '\'' +
                ", quarter='" + quarter + '\'' +
                ", yspj='" + yspj + '\'' +
                ", yszk='" + yszk + '\'' +
                ", ldzchj='" + ldzchj + '\'' +
                ", gdzj='" + gdzj + '\'' +
                ", wxzj='" + wxzj + '\'' +
                ", sy='" + sy + '\'' +
                ", fldzchj='" + fldzchj + '\'' +
                ", zchj='" + zchj + '\'' +
                ", ldfzhj='" + ldfzhj + '\'' +
                ", fldfzhj='" + fldfzhj + '\'' +
                ", fzhj='" + fzhj + '\'' +
                ", syzqy='" + syzqy + '\'' +
                '}';
    }
}
