package com.persian.data.em;

import java.io.Serializable;

/**
 * @author: dave01.zhou  Time: 2018/8/2 18:47
 */
public class EmStockDesc implements Serializable, Cloneable {
    private String code;
    private String nameCn;
    private String weight;        // 权重(%)

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EmStockDesc{" +
                "code='" + code + '\'' +
                ", nameCn='" + nameCn + '\'' +
                ", weight='" + weight + '\'' +
                '}';
    }
}
