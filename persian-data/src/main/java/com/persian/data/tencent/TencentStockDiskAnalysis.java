package com.persian.data.tencent;

import java.io.Serializable;

/**
 * @author: dave01.zhou  Time: 2018/7/29 17:07
 */
public class TencentStockDiskAnalysis implements Serializable, Cloneable {
    private String buyBig;        // 买盘大单
    private String buySmall;      // 买盘小单
    private String sellBig;       // 卖盘大单
    private String sellSmall;     // 卖盘小单

    public String getBuyBig() {
        return buyBig;
    }

    public void setBuyBig(String buyBig) {
        this.buyBig = buyBig;
    }

    public String getBuySmall() {
        return buySmall;
    }

    public void setBuySmall(String buySmall) {
        this.buySmall = buySmall;
    }

    public String getSellBig() {
        return sellBig;
    }

    public void setSellBig(String sellBig) {
        this.sellBig = sellBig;
    }

    public String getSellSmall() {
        return sellSmall;
    }

    public void setSellSmall(String sellSmall) {
        this.sellSmall = sellSmall;
    }
}
