package com.persian.data;

/**
 * @author: dave01.zhou  Time: 2018/7/31 0:14
 */
public enum MinuteLineType {
    MINUTE_1("1分钟分时线"),
    MINUTE_5("5分钟分时线"),
    MINUTE_10("10分钟分时线"),
    MINUTE_15("15分钟分时线"),
    MINUTE_30("20分钟分时线"),
    MINUTE_60("30分钟分时线");

    private String description;

    MinuteLineType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
