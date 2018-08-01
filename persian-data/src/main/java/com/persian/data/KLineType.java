package com.persian.data;

/**
 * @author: dave01.zhou  Time: 2018/7/26 23:28
 */
public enum KLineType {
    DAILY("日K线"),
    WEEKLY("周K线"),
    MONTHLY("月K线");

    private String description;

    KLineType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
