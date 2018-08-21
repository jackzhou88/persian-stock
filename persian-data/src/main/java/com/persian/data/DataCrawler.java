package com.persian.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.persian.data.util.HttpClient;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * @author: dave01.zhou  Time: 2018/7/28 21:59
 */
public abstract class DataCrawler {
    private static final Logger logger = LoggerFactory.getLogger(DataCrawler.class);
    protected static final int BULK_QUERY_COUNT = 100;
    protected static final String LINE_SEPARATOR = "\n";
    protected static final char DOUBLE_QUOTE = '"';
    protected static final String STOCK_CODE_FORMAT = "%06d";
    protected static final OkHttpClient httpClient = HttpClient.getOkHttpClient();
    protected static final ObjectMapper jsonMapper = new ObjectMapper();
    protected static final CsvMapper csvMapper = new CsvMapper()
            .enable(CsvParser.Feature.TRIM_SPACES)
            .enable(CsvParser.Feature.IGNORE_TRAILING_UNMAPPABLE)
            .enable(CsvParser.Feature.SKIP_EMPTY_LINES);

    protected <T> T commonQuery(String url, Function<String, T> dataParser) {
        try {
            Request request = new Request.Builder().url(url).build();
            Response response = httpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                logger.error("commonQuery error for url: {}, statusCode: {}", url, response.code());
                return null;
            }
            String data = response.body().string();
            if (data != null && !data.isEmpty()) {
                return dataParser.apply(data);
            }
        } catch (Exception e) {
            logger.error("commonQuery error for url: " + url, e);
        }
        return null;
    }

    protected <T> T commonDownloadSync(String url, Function<InputStream, T> fileParser) {
        try {
            Request request = new Request.Builder().url(url).build();
            Response response = httpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                logger.error("commonDownload error for url: {}, statusCode: {}", url, response.code());
            }
            return fileParser.apply(response.body().byteStream());
        } catch (Exception e) {
            logger.error("commonDownload error for url: " + url, e);
        }
        return null;
    }

    protected <T> Map<String, T> stockQueryBulk(StockType type, String queryApi,
                                                Function<Integer, String> codeFormatter,
                                                BiConsumer<String, Map<String, T>> dataParser) {
        int codeMin = Integer.valueOf(type.getMinCode());
        int codeMax = Integer.valueOf(type.getMaxCode());
        Map<String, T> results = new LinkedHashMap<>();
        String codesStr = "";
        int bulkCount = 0;
        for (int code = codeMin; code <= codeMax; ++code) {
            codesStr += codeFormatter.apply(code) + ",";
            bulkCount++;
            if (bulkCount == BULK_QUERY_COUNT || code == codeMax) {
                String url = String.format(queryApi, codesStr);
                try {
                    Request request = new Request.Builder().url(url).build();
                    Response response = httpClient.newCall(request).execute();
                    if (!response.isSuccessful()) {
                        logger.error("stockQueryBulk error for url: {}, statusCode: {}", url, response.code());
                        continue;
                    }
                    String data = response.body().string();
                    if (data != null && !data.isEmpty()) {
                        dataParser.accept(data, results);
                    }
                } catch (Exception e) {
                    logger.error("stockQueryBulk error for url: " + url, e);
                }
                codesStr = "";
                bulkCount = 0;
            }
        }
        return results;
    }
}
