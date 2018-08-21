package com.persian.data.tushare;

import java.io.Serializable;

/**
 * @author: dave01.zhou  Time: 2018/8/9 17:05
 */
public class TushareStockIssuance implements Serializable, Cloneable {
    private String code;
    private String name;
    private String type;                  // 类型，定向增发/公开增发
    private String count;                 // 数量
    private String price;                 // 增发价格
    private String close;                 // 最近收盘价
    private String issue_date;            // 增发日期
    private String list_date;             // 上市日期
    private String locked_year;           // 锁定年数

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    public String getList_date() {
        return list_date;
    }

    public void setList_date(String list_date) {
        this.list_date = list_date;
    }

    public String getLocked_year() {
        return locked_year;
    }

    public void setLocked_year(String locked_year) {
        this.locked_year = locked_year;
    }

    @Override
    public String toString() {
        return "TushareStockIssuance{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", count='" + count + '\'' +
                ", price='" + price + '\'' +
                ", close='" + close + '\'' +
                ", issue_date='" + issue_date + '\'' +
                ", list_date='" + list_date + '\'' +
                ", locked_year='" + locked_year + '\'' +
                '}';
    }
}
