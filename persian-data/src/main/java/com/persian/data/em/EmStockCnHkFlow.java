package com.persian.data.em;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;

/**
 * @author: dave01.zhou  Time: 2018/8/2 23:10
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE)
public class EmStockCnHkFlow implements Serializable, Cloneable {
    private String DateTime;          // 时间（yyyy-MM-dd）
    private String HSMoney;           // 沪港通（单位：百万元）
    private String SSMoney;           // 深港通
    private String GGHSMoney;         // 港股通(沪)
    private String GGSSMoney;         // 港股通(深)
    private String NorthMoney;        // 北向资金流入
    private String SouthSumMoney;     // 南向资金流入

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public String getHSMoney() {
        return HSMoney;
    }

    public void setHSMoney(String HSMoney) {
        this.HSMoney = HSMoney;
    }

    public String getSSMoney() {
        return SSMoney;
    }

    public void setSSMoney(String SSMoney) {
        this.SSMoney = SSMoney;
    }

    public String getGGHSMoney() {
        return GGHSMoney;
    }

    public void setGGHSMoney(String GGHSMoney) {
        this.GGHSMoney = GGHSMoney;
    }

    public String getGGSSMoney() {
        return GGSSMoney;
    }

    public void setGGSSMoney(String GGSSMoney) {
        this.GGSSMoney = GGSSMoney;
    }

    public String getNorthMoney() {
        return NorthMoney;
    }

    public void setNorthMoney(String northMoney) {
        NorthMoney = northMoney;
    }

    public String getSouthSumMoney() {
        return SouthSumMoney;
    }

    public void setSouthSumMoney(String southSumMoney) {
        SouthSumMoney = southSumMoney;
    }

    @Override
    public String toString() {
        return "EmStockCnHkFlow{" +
                "DateTime='" + DateTime + '\'' +
                ", HSMoney='" + HSMoney + '\'' +
                ", SSMoney='" + SSMoney + '\'' +
                ", GGHSMoney='" + GGHSMoney + '\'' +
                ", GGSSMoney='" + GGSSMoney + '\'' +
                ", NorthMoney='" + NorthMoney + '\'' +
                ", SouthSumMoney='" + SouthSumMoney + '\'' +
                '}';
    }
}
