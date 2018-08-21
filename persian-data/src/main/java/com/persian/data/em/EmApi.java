package com.persian.data.em;

/**
 * @author: dave01.zhou  Time: 2018/8/1 22:29
 */
public class EmApi {
    // 沪深港通资金流向数据：历史上每天的资金流向
    public static final String CN_HK_FLOW = "http://dcfm.eastmoney.com/EM_MutiSvcExpandInterface/api/js/get?type=HSGTZJZS&token=70f12f2f4f091e459a279469fe49eca5";
    // 限售股解禁数据：参数为年份(yyyy)，月份(MM)，返回JSON格式`
    public static final String RESTRICTED_UNLOCK = "http://datainterface.eastmoney.com/EM_DataCenter/JS.aspx?type=FD&sty=BST&st=3&sr=true&fd=%d&stat=%d";
    // 十大股东列表历史数据
    public static final String TOP10_HOLDERS = "http://webf10.gw.com.cn/SDGD/SDGD%s.js";

    // 各指数成份股
    public static final String SH50_LIST = "http://www.csindex.com.cn/uploads/file/autofile/cons/000016cons.xls";
    public static final String HS300_LIST = "http://www.csindex.com.cn/uploads/file/autofile/closeweight/000300closeweight.xls";
    public static final String ZZ500_LIST = "http://www.csindex.com.cn/uploads/file/autofile/closeweight/000905closeweight.xls";
}
