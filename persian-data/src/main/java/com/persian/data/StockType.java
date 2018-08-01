package com.persian.data;

/**
 * @author: dave01.zhou  Time: 2018/7/26 10:24
 */
public enum StockType {
    SH_A("600000", "610000", "sh"),
    SH_B("900900", "901000", "sh"),
    SZ_A("000001", "005000", "sz"),
    SZ_B("200002", "202000", "sz"),
    SZ_GEM("300001", "302000", "sz"),
    
    HK("00001", "10000", "hk");

    private String minCode;
    private String maxCode;
    private String symbol;

    StockType(String minCode, String maxCode, String symbol) {
        this.minCode = minCode;
        this.maxCode = maxCode;
        this.symbol = symbol;
    }

    public boolean isCN() {
        return ordinal() <= SZ_GEM.ordinal();
    }

    public String getMinCode() {
        return minCode;
    }

    public String getMaxCode() {
        return maxCode;
    }

    public String getSymbol() {
        return symbol;
    }
}
