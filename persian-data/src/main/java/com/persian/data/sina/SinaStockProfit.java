package com.persian.data.sina;

import java.io.Serializable;

/**
 * 财务报表：利润表
 *
 * @author: dave01.zhou  Time: 2018/8/5 10:57
 */
public class SinaStockProfit implements Serializable, Cloneable {
    private String code;         // 股票代码
    private String quarter;      // 季度，yyyyMMdd

    private String yyzsr;        // 营业总收入（元）

    private String yyzcb;        // 营业总成本（元）
    private String xsfy;         // 销售费用
    private String glfy;         // 管理费用
    private String cwfy;         // 财务费用

    private String tzsy;         // 投资收益
    private String yylr;         // 营业利润
    private String lrze;         // 利润总额
    private String jlr;          // 净利润

    private String mgsy;         // 每股收益
    private String zhsyze;       // 综合收益总额

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

    public String getYyzsr() {
        return yyzsr;
    }

    public void setYyzsr(String yyzsr) {
        this.yyzsr = yyzsr;
    }

    public String getYyzcb() {
        return yyzcb;
    }

    public void setYyzcb(String yyzcb) {
        this.yyzcb = yyzcb;
    }

    public String getXsfy() {
        return xsfy;
    }

    public void setXsfy(String xsfy) {
        this.xsfy = xsfy;
    }

    public String getGlfy() {
        return glfy;
    }

    public void setGlfy(String glfy) {
        this.glfy = glfy;
    }

    public String getCwfy() {
        return cwfy;
    }

    public void setCwfy(String cwfy) {
        this.cwfy = cwfy;
    }

    public String getTzsy() {
        return tzsy;
    }

    public void setTzsy(String tzsy) {
        this.tzsy = tzsy;
    }

    public String getYylr() {
        return yylr;
    }

    public void setYylr(String yylr) {
        this.yylr = yylr;
    }

    public String getLrze() {
        return lrze;
    }

    public void setLrze(String lrze) {
        this.lrze = lrze;
    }

    public String getJlr() {
        return jlr;
    }

    public void setJlr(String jlr) {
        this.jlr = jlr;
    }

    public String getMgsy() {
        return mgsy;
    }

    public void setMgsy(String mgsy) {
        this.mgsy = mgsy;
    }

    public String getZhsyze() {
        return zhsyze;
    }

    public void setZhsyze(String zhsyze) {
        this.zhsyze = zhsyze;
    }

    @Override
    public String toString() {
        return "SinaStockProfit{" +
                "code='" + code + '\'' +
                ", quarter='" + quarter + '\'' +
                ", yyzsr='" + yyzsr + '\'' +
                ", yyzcb='" + yyzcb + '\'' +
                ", xsfy='" + xsfy + '\'' +
                ", glfy='" + glfy + '\'' +
                ", cwfy='" + cwfy + '\'' +
                ", tzsy='" + tzsy + '\'' +
                ", yylr='" + yylr + '\'' +
                ", lrze='" + lrze + '\'' +
                ", jlr='" + jlr + '\'' +
                ", mgsy='" + mgsy + '\'' +
                ", zhsyze='" + zhsyze + '\'' +
                '}';
    }
}
