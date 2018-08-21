package com.persian.data.sina;

/**
 * @author: dave01.zhou  Time: 2018/7/25 14:39
 */
public class SinaApi {
    // 实时行情数据：股票、指数、股指期货、基金、银行汇率、基金等等（CSV格式）
    public static final String HQ_SERVICE = "http://hq.sinajs.cn/format=text&list=%s";

    // K线数据：K线图（gif图片），参数为K线类型（daily, weekly, monthly），股票代码
    public static final String KLINE_CHART_LATEST = "http://image.sinajs.cn/newchart/%s/n/%s.gif";

    // 分时数据：参数为股票编号、分钟间隔（5、15、30、60）、均值（no、5、10、15、20、25），最多242条数据，JSON格式
    public static final String MINUTE_LINE_DATA = "http://money.finance.sina.com.cn/quotes_service/api/json_v2.php/CN_MarketData.getKLineData?symbol=%s&scale=%s&ma=no&datalen=1023";
    public static final String MINUTE_LINE_CHART = "http://image.sinajs.cn/newchart/min/n/%s.gif";

    // 股价复权数据：前复权、后复权数据
    public static final String PRICE_RESTORE_PRE = "http://finance.sina.com.cn/realstock/company/%s/qianfuquan.js";
    public static final String PRICE_RESTORE_POST = "http://finance.sina.com.cn/realstock/company/%s/houfuquan.js";

    // 股票分价表数据：指定日期范围yyyy-MM-dd内的股票分价表（HTML格式）
    public static final String PRICE_LINE_DATA = "http://market.finance.sina.com.cn/pricehis.php?symbol=%s&startdate=%s&enddate=%s";

    // 财务报表数据：利润表，资产负债表，现金流量表（xls文件）
    public static final String STATEMENT_INCOME_PROFIT = "http://money.finance.sina.com.cn/corp/go.php/vDOWN_ProfitStatement/displaytype/4/stockid/%s/ctrl/all.phtml";
    public static final String STATEMENT_BALANCE_SHEET = "http://money.finance.sina.com.cn/corp/go.php/vDOWN_BalanceSheet/displaytype/4/stockid/%s/ctrl/all.phtml";
    public static final String STATEMENT_CASH_FLOW = "http://money.finance.sina.com.cn/corp/go.php/vDOWN_CashFlow/displaytype/4/stockid/%s/ctrl/all.phtml";
}
