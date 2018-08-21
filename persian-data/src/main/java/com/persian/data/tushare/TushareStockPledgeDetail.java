package com.persian.data.tushare;

import java.io.Serializable;

/**
 * @author: dave01.zhou  Time: 2018/8/9 16:53
 */
public class TushareStockPledgeDetail implements Serializable, Cloneable {
    private String code;
    private String name;
    private String ann_date;        // 公告日期 yyyyMMdd
    private String pledgor;         // 出质人
    private String pledgee;         // 质权人
    private String volume;          // 质押数量
    private String from_date;       // 质押日期
    private String end_date;        // 解除日期

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

    public String getAnn_date() {
        return ann_date;
    }

    public void setAnn_date(String ann_date) {
        this.ann_date = ann_date;
    }

    public String getPledgor() {
        return pledgor;
    }

    public void setPledgor(String pledgor) {
        this.pledgor = pledgor;
    }

    public String getPledgee() {
        return pledgee;
    }

    public void setPledgee(String pledgee) {
        this.pledgee = pledgee;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getFrom_date() {
        return from_date;
    }

    public void setFrom_date(String from_date) {
        this.from_date = from_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "TushareStockPledgeDetail{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", ann_date='" + ann_date + '\'' +
                ", pledgor='" + pledgor + '\'' +
                ", pledgee='" + pledgee + '\'' +
                ", volume='" + volume + '\'' +
                ", from_date='" + from_date + '\'' +
                ", end_date='" + end_date + '\'' +
                '}';
    }
}
