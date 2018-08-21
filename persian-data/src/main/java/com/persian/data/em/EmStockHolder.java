package com.persian.data.em;

import java.io.Serializable;

/**
 * @author: dave01.zhou  Time: 2018/8/3 14:07
 */
public class EmStockHolder implements Serializable, Cloneable {
    private String cgs;               // 持股数（万股）
    private String gbxz;              // 股本性质（流通A股，流通B股）
    private String gddm;              // 股东代码
    private String gdmc;              // 股东名称
    private String gdmcEncode;        // encode后的股东名称
    private String x;                 // 序号，即股东名次
    private String zjqk;              // 增减情况(万股，或者未变)
    private String zjqkCss;           // 增减情况的CSS显示颜色
    private String zzgs;              // 占总股数(%)

    public String getCgs() {
        return cgs;
    }

    public void setCgs(String cgs) {
        this.cgs = cgs;
    }

    public String getGbxz() {
        return gbxz;
    }

    public void setGbxz(String gbxz) {
        this.gbxz = gbxz;
    }

    public String getGddm() {
        return gddm;
    }

    public void setGddm(String gddm) {
        this.gddm = gddm;
    }

    public String getGdmc() {
        return gdmc;
    }

    public void setGdmc(String gdmc) {
        this.gdmc = gdmc;
    }

    public String getGdmcEncode() {
        return gdmcEncode;
    }

    public void setGdmcEncode(String gdmcEncode) {
        this.gdmcEncode = gdmcEncode;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getZjqk() {
        return zjqk;
    }

    public void setZjqk(String zjqk) {
        this.zjqk = zjqk;
    }

    public String getZjqkCss() {
        return zjqkCss;
    }

    public void setZjqkCss(String zjqkCss) {
        this.zjqkCss = zjqkCss;
    }

    public String getZzgs() {
        return zzgs;
    }

    public void setZzgs(String zzgs) {
        this.zzgs = zzgs;
    }

    @Override
    public String toString() {
        return "EmStockHolder{" +
                "cgs='" + cgs + '\'' +
                ", gbxz='" + gbxz + '\'' +
                ", gddm='" + gddm + '\'' +
                ", gdmc='" + gdmc + '\'' +
                ", gdmcEncode='" + gdmcEncode + '\'' +
                ", x='" + x + '\'' +
                ", zjqk='" + zjqk + '\'' +
                ", zjqkCss='" + zjqkCss + '\'' +
                ", zzgs='" + zzgs + '\'' +
                '}';
    }
}
