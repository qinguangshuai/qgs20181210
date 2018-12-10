package com.bw.qgs.qgs20181210.url;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * date:2018/12/10    9:22
 * author:秦广帅(Lenovo)
 * fileName:HttpUtil
 */
public class HttpUtil {

    public static final String METHOD_GET = "GET";
    private static OkHttpClient client;
    public static Retrofit sRetrofit;

    public HttpUtil() {
    }

    public static void init() {
        client = new OkHttpClient.Builder()
                .build();
        //retrofit
//rxjava
        sRetrofit = new Retrofit.Builder().baseUrl(UrlUtil.PATH1)
                //retrofit
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                //rxjava
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static Request creat(String url, String method) {
        Request.Builder builder = new Request.Builder().url(url);
        Request request = null;
        switch (method) {
            case METHOD_GET:
                request = builder.build();
                break;
        }
        return request;
    }

    public static void enqueueGet(String url, Callback callback) {
        Request request = creat(url, METHOD_GET);
        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
