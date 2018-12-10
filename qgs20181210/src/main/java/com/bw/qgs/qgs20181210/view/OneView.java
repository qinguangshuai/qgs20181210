package com.bw.qgs.qgs20181210.view;

import retrofit2.Call;

/**
 * date:2018/12/10    9:05
 * author:秦广帅(Lenovo)
 * fileName:OneView
 */
public interface OneView {
    void onSuccess(String result);
    void onFailer(Call<String> call, Throwable t);
}
