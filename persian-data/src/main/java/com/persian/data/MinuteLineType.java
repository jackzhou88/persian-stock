package com.persian.data;

/**
 * @author: dave01.zhou  Time: 2018/7/31 0:14
 */
public enum MinuteLineType {
    MINUTE_5("5"),
    MINUTE_15("15"),
    MINUTE_30("30"),
    MINUTE_60("60");

    private String code;

    MinuteLineType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
