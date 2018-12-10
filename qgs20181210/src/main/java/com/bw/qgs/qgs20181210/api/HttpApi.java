package com.bw.qgs.qgs20181210.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * date:2018/12/10    9:08
 * author:秦广帅(Lenovo)
 * fileName:HttpApi
 */
public interface HttpApi {
    @GET
    Call<String> getMethod(@Url String url);
}
