package com.persian.data;

/**
 * @author: dave01.zhou  Time: 2018/7/26 11:53
 */
public enum IndexType {
    SH("000001", "sh"),
    SZ_SME("399001", "sz"),
    SZ_GEM("399006", "sz"),
    SH_50("000016", "sh"),
    HS_300("000300", "sh"),
    ZZ_500("000905", "sh");

    private String code;
    private String symbol;

    IndexType(String code, String symbol) {
        this.code = code;
        this.symbol = symbol;
    }

    public boolean isCN() {
        return ordinal() <= ZZ_500.ordinal();
    }

    public String getCode() {
        return code;
    }

    public String getSymbol() {
        return symbol;
    }
}
