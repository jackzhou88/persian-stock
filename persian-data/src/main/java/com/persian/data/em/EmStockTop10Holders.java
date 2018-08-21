package com.persian.data.em;

import java.io.Serializable;
import java.util.List;

/**
 * @author: dave01.zhou  Time: 2018/8/3 13:44
 */
public class EmStockTop10Holders implements Serializable, Cloneable {
    private String jzrq;        // 截至日期
    private String jzrqCss;     // CSS显示颜色
    private String ljbh;        // 累计变化（万股）
    private String ljbhCss;     // CSS显示颜色
    private String ljcy;        // 累计持有（万股）
    private String ljzb;        // 累计占比(%)
    private List<EmStockHolder> sdgdList;        // 10大股东列表
    private String tableCss;                     // table颜色
    private List<EmStockHolder> tcgdList;        // 退出股东列表
    private String xh;                           // 序号

    public String getJzrq() {
        return jzrq;
    }

    public void setJzrq(String jzrq) {
        this.jzrq = jzrq;
    }

    public String getJzrqCss() {
        return jzrqCss;
    }

    public void setJzrqCss(String jzrqCss) {
        this.jzrqCss = jzrqCss;
    }

    public String getLjbh() {
        return ljbh;
    }

    public void setLjbh(String ljbh) {
        this.ljbh = ljbh;
    }

    public String getLjbhCss() {
        return ljbhCss;
    }

    public void setLjbhCss(String ljbhCss) {
        this.ljbhCss = ljbhCss;
    }

    public String getLjcy() {
        return ljcy;
    }

    public void setLjcy(String ljcy) {
        this.ljcy = ljcy;
    }

    public String getLjzb() {
        return ljzb;
    }

    public void setLjzb(String ljzb) {
        this.ljzb = ljzb;
    }

    public List<EmStockHolder> getSdgdList() {
        return sdgdList;
    }

    public void setSdgdList(List<EmStockHolder> sdgdList) {
        this.sdgdList = sdgdList;
    }

    public String getTableCss() {
        return tableCss;
    }

    public void setTableCss(String tableCss) {
        this.tableCss = tableCss;
    }

    public List<EmStockHolder> getTcgdList() {
        return tcgdList;
    }

    public void setTcgdList(List<EmStockHolder> tcgdList) {
        this.tcgdList = tcgdList;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    @Override
    public String toString() {
        return "EmStockTop10Holders{" +
                "jzrq='" + jzrq + '\'' +
                ", jzrqCss='" + jzrqCss + '\'' +
                ", ljbh='" + ljbh + '\'' +
                ", ljbhCss='" + ljbhCss + '\'' +
                ", ljcy='" + ljcy + '\'' +
                ", ljzb='" + ljzb + '\'' +
                ", sdgdList=" + sdgdList +
                ", tableCss='" + tableCss + '\'' +
                ", tcgdList=" + tcgdList +
                ", xh='" + xh + '\'' +
                '}';
    }
}
