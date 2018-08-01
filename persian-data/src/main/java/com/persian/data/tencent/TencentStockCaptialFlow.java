package com.persian.data.tencent;

import java.io.Serializable;

/**
 * @author: dave01.zhou  Time: 2018/7/29 16:07
 */
public class TencentStockCaptialFlow implements Serializable, Cloneable {
    private String code;
    private String majorInflow;           // 主力流入
    private String majorOutflow;
    private String majorNet;              // 主力净流入
    private String majorNetRatio;         // 主力净流入/资金流入流出总和
    private String minorInflow;           // 散户流入
    private String minorOutflow;
    private String minorNet;              // 散户净流入
    private String minorNetRatio;         // 散户净流入/资金流入流出总和
    private String total;                 // 资金流入流出总和1+2+5+6
    private String unknown1;
    private String unknown2;
    private String nameCn;
    private String date;                // yyMMdd
    private String date1_Unknown1;      // 过去4天的资金流向
    private String date2_Unknown2;
    private String date3_Unknown3;
    private String date4_Unknown4;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMajorInflow() {
        return majorInflow;
    }

    public void setMajorInflow(String majorInflow) {
        this.majorInflow = majorInflow;
    }

    public String getMajorOutflow() {
        return majorOutflow;
    }

    public void setMajorOutflow(String majorOutflow) {
        this.majorOutflow = majorOutflow;
    }

    public String getMajorNet() {
        return majorNet;
    }

    public void setMajorNet(String majorNet) {
        this.majorNet = majorNet;
    }

    public String getMajorNetRatio() {
        return majorNetRatio;
    }

    public void setMajorNetRatio(String majorNetRatio) {
        this.majorNetRatio = majorNetRatio;
    }

    public String getMinorInflow() {
        return minorInflow;
    }

    public void setMinorInflow(String minorInflow) {
        this.minorInflow = minorInflow;
    }

    public String getMinorOutflow() {
        return minorOutflow;
    }

    public void setMinorOutflow(String minorOutflow) {
        this.minorOutflow = minorOutflow;
    }

    public String getMinorNet() {
        return minorNet;
    }

    public void setMinorNet(String minorNet) {
        this.minorNet = minorNet;
    }

    public String getMinorNetRatio() {
        return minorNetRatio;
    }

    public void setMinorNetRatio(String minorNetRatio) {
        this.minorNetRatio = minorNetRatio;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getUnknown1() {
        return unknown1;
    }

    public void setUnknown1(String unknown1) {
        this.unknown1 = unknown1;
    }

    public String getUnknown2() {
        return unknown2;
    }

    public void setUnknown2(String unknown2) {
        this.unknown2 = unknown2;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate1_Unknown1() {
        return date1_Unknown1;
    }

    public void setDate1_Unknown1(String date1_Unknown1) {
        this.date1_Unknown1 = date1_Unknown1;
    }

    public String getDate2_Unknown2() {
        return date2_Unknown2;
    }

    public void setDate2_Unknown2(String date2_Unknown2) {
        this.date2_Unknown2 = date2_Unknown2;
    }

    public String getDate3_Unknown3() {
        return date3_Unknown3;
    }

    public void setDate3_Unknown3(String date3_Unknown3) {
        this.date3_Unknown3 = date3_Unknown3;
    }

    public String getDate4_Unknown4() {
        return date4_Unknown4;
    }

    public void setDate4_Unknown4(String date4_Unknown4) {
        this.date4_Unknown4 = date4_Unknown4;
    }
}
