package com.bw.qgs.qgs20181210.call;

import retrofit2.Call;

/**
 * date:2018/12/10    9:03
 * author:秦广帅(Lenovo)
 * fileName:CallBack
 */
public interface CallBack {
    void onSuccess(String result);
    void onFailer(Call<String> call,Throwable t);
}
