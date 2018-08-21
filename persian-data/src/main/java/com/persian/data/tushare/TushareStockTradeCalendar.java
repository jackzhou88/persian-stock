package com.persian.data.tushare;

import java.io.Serializable;

/**
 * @author: dave01.zhou  Time: 2018/8/9 17:19
 */
public class TushareStockTradeCalendar implements Serializable, Cloneable {
    private String calendarDate;    // 交易日期，yyyy-MM-dd
    private String isOpen;          // isOpen=1是交易日，isOpen=0为休市

    public void setCalendarDate(String calendarDate) {
        this.calendarDate = calendarDate;
    }

    public void setIsOpen(String isOpen) {
        this.isOpen = isOpen;
    }

    @Override
    public String toString() {
        return "TushareStockTradeCalendar{" +
                "calendarDate='" + calendarDate + '\'' +
                ", isOpen='" + isOpen + '\'' +
                '}';
    }
}
