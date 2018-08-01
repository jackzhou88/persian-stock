package com.persian.data.tencent;

import java.io.Serializable;

/**
 * @author: dave01.zhou  Time: 2018/7/28 16:15
 */
public class TencentStockRealtimeDetail implements Serializable, Cloneable {
    private String unknown1;
    private String nameCn;
    private String code;

    private String latest;
    private String close;
    private String open;
    private String volume;        // 成交量（手，百股数）
    private String buy;           // 外盘量（手）
    private String sell;          // 内盘量（手，volume = buy + sell）

    private String bid1;          // 买1价
    private String bid1Volume;    // 买一量（手）
    private String bid2;
    private String bid2Vol;
    private String bid3;
    private String bid3Volume;
    private String bid4;
    private String bid4Volume;
    private String bid5;
    private String bid5Volume;
    private String ask1;
    private String ask1Volume;
    private String ask2;
    private String ask2Volume;
    private String ask3;
    private String ask3Volume;
    private String ask4;
    private String ask4Volume;
    private String ask5;
    private String ask5Volume;
    private String dealList;           // 最近逐笔成交

    private String time;               // yyyyMMddHHmmss
    private String change;
    private String changePercent;
    private String high;
    private String low;
    private String latest_Volume_Amount;        // 价格/成交量（手）/成交额
    private String volumeDuplicate;             // 成交量（手）
    private String amount;                      // 成交额（万元）

    private String turnover;                    // 换手率，成交量/流通总股数*100%
    private String pe;                          // PE TTM

    private String unknown2;
    private String highDupicate;
    private String lowDuplicate;
    private String amplitude;             // 振幅%，(high-low)/close * 100%
    private String marketValue;           // 流通市值（亿元）
    private String totalValue;            // 总市值（亿元）
    private String pb;
    private String limitUp;              // 涨停价，close*1.1
    private String limitDown;            // 跌停价，close*0.9
    private String qr;                   // 量比，quantity relative，（现成交总手数/现累计开市时间(分)/过去5日平均每分钟成交量
    private String committeeDifferent;   // 委差，委买手数－委卖手数

    private String unknown3;
    private String unknown4;
    private String unknown5;

    public String getUnknown1() {
        return unknown1;
    }

    public void setUnknown1(String unknown1) {
        this.unknown1 = unknown1;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLatest() {
        return latest;
    }

    public void setLatest(String latest) {
        this.latest = latest;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public String getBid1() {
        return bid1;
    }

    public void setBid1(String bid1) {
        this.bid1 = bid1;
    }

    public String getBid1Volume() {
        return bid1Volume;
    }

    public void setBid1Volume(String bid1Volume) {
        this.bid1Volume = bid1Volume;
    }

    public String getBid2() {
        return bid2;
    }

    public void setBid2(String bid2) {
        this.bid2 = bid2;
    }

    public String getBid2Vol() {
        return bid2Vol;
    }

    public void setBid2Vol(String bid2Vol) {
        this.bid2Vol = bid2Vol;
    }

    public String getBid3() {
        return bid3;
    }

    public void setBid3(String bid3) {
        this.bid3 = bid3;
    }

    public String getBid3Volume() {
        return bid3Volume;
    }

    public void setBid3Volume(String bid3Volume) {
        this.bid3Volume = bid3Volume;
    }

    public String getBid4() {
        return bid4;
    }

    public void setBid4(String bid4) {
        this.bid4 = bid4;
    }

    public String getBid4Volume() {
        return bid4Volume;
    }

    public void setBid4Volume(String bid4Volume) {
        this.bid4Volume = bid4Volume;
    }

    public String getBid5() {
        return bid5;
    }

    public void setBid5(String bid5) {
        this.bid5 = bid5;
    }

    public String getBid5Volume() {
        return bid5Volume;
    }

    public void setBid5Volume(String bid5Volume) {
        this.bid5Volume = bid5Volume;
    }

    public String getAsk1() {
        return ask1;
    }

    public void setAsk1(String ask1) {
        this.ask1 = ask1;
    }

    public String getAsk1Volume() {
        return ask1Volume;
    }

    public void setAsk1Volume(String ask1Volume) {
        this.ask1Volume = ask1Volume;
    }

    public String getAsk2() {
        return ask2;
    }

    public void setAsk2(String ask2) {
        this.ask2 = ask2;
    }

    public String getAsk2Volume() {
        return ask2Volume;
    }

    public void setAsk2Volume(String ask2Volume) {
        this.ask2Volume = ask2Volume;
    }

    public String getAsk3() {
        return ask3;
    }

    public void setAsk3(String ask3) {
        this.ask3 = ask3;
    }

    public String getAsk3Volume() {
        return ask3Volume;
    }

    public void setAsk3Volume(String ask3Volume) {
        this.ask3Volume = ask3Volume;
    }

    public String getAsk4() {
        return ask4;
    }

    public void setAsk4(String ask4) {
        this.ask4 = ask4;
    }

    public String getAsk4Volume() {
        return ask4Volume;
    }

    public void setAsk4Volume(String ask4Volume) {
        this.ask4Volume = ask4Volume;
    }

    public String getAsk5() {
        return ask5;
    }

    public void setAsk5(String ask5) {
        this.ask5 = ask5;
    }

    public String getAsk5Volume() {
        return ask5Volume;
    }

    public void setAsk5Volume(String ask5Volume) {
        this.ask5Volume = ask5Volume;
    }

    public String getDealList() {
        return dealList;
    }

    public void setDealList(String dealList) {
        this.dealList = dealList;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(String changePercent) {
        this.changePercent = changePercent;
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

    public String getLatest_Volume_Amount() {
        return latest_Volume_Amount;
    }

    public void setLatest_Volume_Amount(String latest_Volume_Amount) {
        this.latest_Volume_Amount = latest_Volume_Amount;
    }

    public String getVolumeDuplicate() {
        return volumeDuplicate;
    }

    public void setVolumeDuplicate(String volumeDuplicate) {
        this.volumeDuplicate = volumeDuplicate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTurnover() {
        return turnover;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover;
    }

    public String getPe() {
        return pe;
    }

    public void setPe(String pe) {
        this.pe = pe;
    }

    public String getUnknown2() {
        return unknown2;
    }

    public void setUnknown2(String unknown2) {
        this.unknown2 = unknown2;
    }

    public String getHighDupicate() {
        return highDupicate;
    }

    public void setHighDupicate(String highDupicate) {
        this.highDupicate = highDupicate;
    }

    public String getLowDuplicate() {
        return lowDuplicate;
    }

    public void setLowDuplicate(String lowDuplicate) {
        this.lowDuplicate = lowDuplicate;
    }

    public String getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(String amplitude) {
        this.amplitude = amplitude;
    }

    public String getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(String marketValue) {
        this.marketValue = marketValue;
    }

    public String getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(String totalValue) {
        this.totalValue = totalValue;
    }

    public String getPb() {
        return pb;
    }

    public void setPb(String pb) {
        this.pb = pb;
    }

    public String getLimitUp() {
        return limitUp;
    }

    public void setLimitUp(String limitUp) {
        this.limitUp = limitUp;
    }

    public String getLimitDown() {
        return limitDown;
    }

    public void setLimitDown(String limitDown) {
        this.limitDown = limitDown;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }

    public String getCommitteeDifferent() {
        return committeeDifferent;
    }

    public void setCommitteeDifferent(String committeeDifferent) {
        this.committeeDifferent = committeeDifferent;
    }

    public String getUnknown3() {
        return unknown3;
    }

    public void setUnknown3(String unknown3) {
        this.unknown3 = unknown3;
    }

    public String getUnknown4() {
        return unknown4;
    }

    public void setUnknown4(String unknown4) {
        this.unknown4 = unknown4;
    }

    public String getUnknown5() {
        return unknown5;
    }

    public void setUnknown5(String unknown5) {
        this.unknown5 = unknown5;
    }

    @Override
    public String toString() {
        return "TencentStockRealtimeDetail{" +
                "unknown1='" + unknown1 + '\'' +
                ", nameCn='" + nameCn + '\'' +
                ", code='" + code + '\'' +
                ", latest='" + latest + '\'' +
                ", close='" + close + '\'' +
                ", open='" + open + '\'' +
                ", volume='" + volume + '\'' +
                ", buy='" + buy + '\'' +
                ", sell='" + sell + '\'' +
                ", bid1='" + bid1 + '\'' +
                ", bid1Volume='" + bid1Volume + '\'' +
                ", bid2='" + bid2 + '\'' +
                ", bid2Vol='" + bid2Vol + '\'' +
                ", bid3='" + bid3 + '\'' +
                ", bid3Volume='" + bid3Volume + '\'' +
                ", bid4='" + bid4 + '\'' +
                ", bid4Volume='" + bid4Volume + '\'' +
                ", bid5='" + bid5 + '\'' +
                ", bid5Volume='" + bid5Volume + '\'' +
                ", ask1='" + ask1 + '\'' +
                ", ask1Volume='" + ask1Volume + '\'' +
                ", ask2='" + ask2 + '\'' +
                ", ask2Volume='" + ask2Volume + '\'' +
                ", ask3='" + ask3 + '\'' +
                ", ask3Volume='" + ask3Volume + '\'' +
                ", ask4='" + ask4 + '\'' +
                ", ask4Volume='" + ask4Volume + '\'' +
                ", ask5='" + ask5 + '\'' +
                ", ask5Volume='" + ask5Volume + '\'' +
                ", dealList='" + dealList + '\'' +
                ", time='" + time + '\'' +
                ", change='" + change + '\'' +
                ", changePercent='" + changePercent + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", latest_Volume_Amount='" + latest_Volume_Amount + '\'' +
                ", volumeDuplicate='" + volumeDuplicate + '\'' +
                ", amount='" + amount + '\'' +
                ", turnover='" + turnover + '\'' +
                ", pe='" + pe + '\'' +
                ", unknown2='" + unknown2 + '\'' +
                ", highDupicate='" + highDupicate + '\'' +
                ", lowDuplicate='" + lowDuplicate + '\'' +
                ", amplitude='" + amplitude + '\'' +
                ", marketValue='" + marketValue + '\'' +
                ", totalValue='" + totalValue + '\'' +
                ", pb='" + pb + '\'' +
                ", limitUp='" + limitUp + '\'' +
                ", limitDown='" + limitDown + '\'' +
                ", qr='" + qr + '\'' +
                ", committeeDifferent='" + committeeDifferent + '\'' +
                ", unknown3='" + unknown3 + '\'' +
                ", unknown4='" + unknown4 + '\'' +
                ", unknown5='" + unknown5 + '\'' +
                '}';
    }
}
