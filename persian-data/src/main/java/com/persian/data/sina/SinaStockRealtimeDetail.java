package com.persian.data.sina;

import java.io.Serializable;

/**
 * @author: dave01.zhou  Time: 2018/7/29 18:24
 */
public class SinaStockRealtimeDetail implements Serializable, Cloneable {
    // 注意：字段定义顺序必须与数据中各字段值顺序保持一致，末尾可以定义额外的数据中不存在的字段

    private String nameCn;

    private String open;
    private String close;
    private String latest;
    private String high;
    private String low;

    private String bid;                 // 竞买价（买1价）
    private String ask;                 // 竞卖价（卖1价）
    private String volume;              // 成交量（单位：股数）
    private String amount;              // 成交额（单位：元）

    private String bid1Volume;
    private String bid1;
    private String bid2Volume;
    private String bid2;
    private String bid3Volume;
    private String bid3;
    private String bid4Volume;
    private String bid4;
    private String bid5Volume;
    private String bid5;
    private String ask1Volume;
    private String ask1;
    private String ask2Volume;
    private String ask2;
    private String ask3Volume;
    private String ask3;
    private String ask4Volume;
    private String ask4;
    private String ask5Volume;
    private String ask5;

    private String date;            // 日期（yyyy-MM-dd）
    private String time;            // 时间（HH:mm:ss）
    private String state;           // 状态(00正常，03停牌）

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getLatest() {
        return latest;
    }

    public void setLatest(String latest) {
        this.latest = latest;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBid1Volume() {
        return bid1Volume;
    }

    public void setBid1Volume(String bid1Volume) {
        this.bid1Volume = bid1Volume;
    }

    public String getBid1() {
        return bid1;
    }

    public void setBid1(String bid1) {
        this.bid1 = bid1;
    }

    public String getBid2Volume() {
        return bid2Volume;
    }

    public void setBid2Volume(String bid2Volume) {
        this.bid2Volume = bid2Volume;
    }

    public String getBid2() {
        return bid2;
    }

    public void setBid2(String bid2) {
        this.bid2 = bid2;
    }

    public String getBid3Volume() {
        return bid3Volume;
    }

    public void setBid3Volume(String bid3Volume) {
        this.bid3Volume = bid3Volume;
    }

    public String getBid3() {
        return bid3;
    }

    public void setBid3(String bid3) {
        this.bid3 = bid3;
    }

    public String getBid4Volume() {
        return bid4Volume;
    }

    public void setBid4Volume(String bid4Volume) {
        this.bid4Volume = bid4Volume;
    }

    public String getBid4() {
        return bid4;
    }

    public void setBid4(String bid4) {
        this.bid4 = bid4;
    }

    public String getBid5Volume() {
        return bid5Volume;
    }

    public void setBid5Volume(String bid5Volume) {
        this.bid5Volume = bid5Volume;
    }

    public String getBid5() {
        return bid5;
    }

    public void setBid5(String bid5) {
        this.bid5 = bid5;
    }

    public String getAsk1Volume() {
        return ask1Volume;
    }

    public void setAsk1Volume(String ask1Volume) {
        this.ask1Volume = ask1Volume;
    }

    public String getAsk1() {
        return ask1;
    }

    public void setAsk1(String ask1) {
        this.ask1 = ask1;
    }

    public String getAsk2Volume() {
        return ask2Volume;
    }

    public void setAsk2Volume(String ask2Volume) {
        this.ask2Volume = ask2Volume;
    }

    public String getAsk2() {
        return ask2;
    }

    public void setAsk2(String ask2) {
        this.ask2 = ask2;
    }

    public String getAsk3Volume() {
        return ask3Volume;
    }

    public void setAsk3Volume(String ask3Volume) {
        this.ask3Volume = ask3Volume;
    }

    public String getAsk3() {
        return ask3;
    }

    public void setAsk3(String ask3) {
        this.ask3 = ask3;
    }

    public String getAsk4Volume() {
        return ask4Volume;
    }

    public void setAsk4Volume(String ask4Volume) {
        this.ask4Volume = ask4Volume;
    }

    public String getAsk4() {
        return ask4;
    }

    public void setAsk4(String ask4) {
        this.ask4 = ask4;
    }

    public String getAsk5Volume() {
        return ask5Volume;
    }

    public void setAsk5Volume(String ask5Volume) {
        this.ask5Volume = ask5Volume;
    }

    public String getAsk5() {
        return ask5;
    }

    public void setAsk5(String ask5) {
        this.ask5 = ask5;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "SinaStockRealtimeDetail{" +
                "nameCn='" + nameCn + '\'' +
                ", open='" + open + '\'' +
                ", close='" + close + '\'' +
                ", latest='" + latest + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", bid='" + bid + '\'' +
                ", ask='" + ask + '\'' +
                ", volume='" + volume + '\'' +
                ", amount='" + amount + '\'' +
                ", bid1Volume='" + bid1Volume + '\'' +
                ", bid1='" + bid1 + '\'' +
                ", bid2Volume='" + bid2Volume + '\'' +
                ", bid2='" + bid2 + '\'' +
                ", bid3Volume='" + bid3Volume + '\'' +
                ", bid3='" + bid3 + '\'' +
                ", bid4Volume='" + bid4Volume + '\'' +
                ", bid4='" + bid4 + '\'' +
                ", bid5Volume='" + bid5Volume + '\'' +
                ", bid5='" + bid5 + '\'' +
                ", ask1Volume='" + ask1Volume + '\'' +
                ", ask1='" + ask1 + '\'' +
                ", ask2Volume='" + ask2Volume + '\'' +
                ", ask2='" + ask2 + '\'' +
                ", ask3Volume='" + ask3Volume + '\'' +
                ", ask3='" + ask3 + '\'' +
                ", ask4Volume='" + ask4Volume + '\'' +
                ", ask4='" + ask4 + '\'' +
                ", ask5Volume='" + ask5Volume + '\'' +
                ", ask5='" + ask5 + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
