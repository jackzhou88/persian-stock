package com.persian.data.tushare;

import java.io.Serializable;

/**
 * @author: dave01.zhou  Time: 2018/8/9 17:16
 */
public class TushareStockIndustryClassified implements Serializable, Cloneable {
    private String code;
    private String name;
    private String c_name;        // 行业名称

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

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    @Override
    public String toString() {
        return "TushareStockIndustryClassified{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", c_name='" + c_name + '\'' +
                '}';
    }
}
