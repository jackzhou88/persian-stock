package com.persian.data.sina;

/**
 * @author: dave01.zhou  Time: 2018/7/25 14:39
 */
public class SinaApi {
    // 实时行情数据：股票、指数、股指期货、基金、银行汇率、基金等等（CSV格式）
    public static final String HQ_SERVICE = "http://hq.sinajs.cn/format=text&list=%s";

    // K线数据：分时线图，日，周，月K线图（gif图片）
    public static final String TIME_LINE_CHART = "http://image.sinajs.cn/newchart/min/n/%s.gif";
    public static final String KLINE_CHART_DAILY = "http://image.sinajs.cn/newchart/daily/n/%s.gif";
    public static final String KLINE_CHART_WEEKLY = "http://image.sinajs.cn/newchart/weekly/n/%s.gif";
    public static final String KLINE_CHART_MONTHLY = "http://image.sinajs.cn/newchart/monthly/n/%s.gif";

    // 分时数据：参数为股票编号、分钟间隔（5、15、30、60）、均值（no、5、10、15、20、25）、查询个数点（最大值242），JSON格式
    public static final String TIME_LINE_MINUTE_MA = "http://money.finance.sina.com.cn/quotes_service/api/json_v2.php/CN_MarketData.getKLineData?symbol=%s&scale=%s&ma=no&datalen=1023";

    // 股价复权数据：前复权、后复权数据
    public static final String PRICE_RESTORE_PRE = "http://finance.sina.com.cn/realstock/company/%s/qianfuquan.js";
    public static final String KLINE_RESTORE_POST = "http://finance.sina.com.cn/realstock/company/%s/houfuquan.js";

    // 股票分价表数据：指定日期范围yyyy-MM-dd内的股票分价表（HTML格式）
    public static final String PRICE_LINE_ = "http://market.finance.sina.com.cn/pricehis.php?symbol=%s&startdate=%s&enddate=%s";

    // 财务数据：利润表，资产负债表，现金流量表（xls文件）
    public static final String PROFIT_STATEMENT = "http://money.finance.sina.com.cn/corp/go.php/vDOWN_ProfitStatement/displaytype/4/stockid/%s/ctrl/all.phtml";
    public static final String BALANCE_SHEET = "http://money.finance.sina.com.cn/corp/go.php/vDOWN_BalanceSheet/displaytype/4/stockid/%s/ctrl/all.phtml";
    public static final String CASH_FLOW = "http://money.finance.sina.com.cn/corp/go.php/vDOWN_CashFlow/displaytype/4/stockid/%s/ctrl/all.phtml";
}
