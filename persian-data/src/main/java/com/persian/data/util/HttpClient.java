package com.persian.data.util;

import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

/**
 * @author: dave01.zhou  Time: 2018/7/28 15:29
 */
public class HttpClient {
    private static OkHttpClient httpClient;

    private HttpClient() {
    }

    public static synchronized OkHttpClient getOkHttpClient() {
        if (httpClient == null) {
            httpClient = new OkHttpClient();
            httpClient.newBuilder().connectTimeout(10, TimeUnit.SECONDS);
            httpClient.newBuilder().readTimeout(10, TimeUnit.SECONDS);
            httpClient.newBuilder().writeTimeout(10, TimeUnit.SECONDS);
        }
        return httpClient;
    }
}
