package com.bw.qgs.qgs20181210.model;

import com.bw.qgs.qgs20181210.api.HttpApi;
import com.bw.qgs.qgs20181210.call.CallBack;
import com.bw.qgs.qgs20181210.url.HttpUtil;
import com.bw.qgs.qgs20181210.url.UrlUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * date:2018/12/10    9:06
 * author:秦广帅(Lenovo)
 * fileName:HttpManager
 */
public class HttpManager {
    public void getMethod(String url, final CallBack callBack) {

        HttpApi httpApi = HttpUtil.sRetrofit.create(HttpApi.class);
        Call<String> call = httpApi.getMethod(url);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                //成功
                String body = response.body();
                callBack.onSuccess(body);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                //失败
                callBack.onFailer(call, t);
            }
        });
    }
}
