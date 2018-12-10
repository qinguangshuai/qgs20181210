package com.bw.qgs.qgs20181210.model;

import android.os.Handler;
import android.os.Message;

import com.bw.qgs.qgs20181210.url.HttpUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * date:2018/12/10    9:27
 * author:秦广帅(Lenovo)
 * fileName:DuanModel
 */
public class DuanModel {
    public void duan(String url, final HttpCall httpCall){
        HttpUtil.enqueueGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String s = response.body().string();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        httpCall.getData(s);
                    }
                });
            }
        });
    }

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    public interface HttpCall{
        void getData(String s);
    }
}
