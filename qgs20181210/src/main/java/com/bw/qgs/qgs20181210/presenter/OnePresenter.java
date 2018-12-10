package com.bw.qgs.qgs20181210.presenter;

import com.bw.qgs.qgs20181210.call.CallBack;
import com.bw.qgs.qgs20181210.model.HttpManager;
import com.bw.qgs.qgs20181210.view.OneView;

import retrofit2.Call;

/**
 * date:2018/12/10    9:13
 * author:秦广帅(Lenovo)
 * fileName:OnePresenter
 */
public class OnePresenter {

    private OneView mOneView;
    private HttpManager mHttpManager;

    public OnePresenter(OneView oneView) {
        mOneView = oneView;
        mHttpManager = new HttpManager();
    }

    public void utilUrl(String url){
        mHttpManager.getMethod(url, new CallBack() {
            @Override
            public void onSuccess(String result) {
                mOneView.onSuccess(result);
            }

            @Override
            public void onFailer(Call<String> call, Throwable t) {
                mOneView.onFailer(call, t);
            }
        });
    }
}
