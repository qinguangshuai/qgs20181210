package com.bw.qgs.qgs20181210.presenter;

import com.bw.qgs.qgs20181210.model.DuanModel;
import com.bw.qgs.qgs20181210.view.DuanView;

/**
 * date:2018/12/10    9:34
 * author:秦广帅(Lenovo)
 * fileName:DuanPresenter
 */
public class DuanPresenter {

    private DuanView mDuanView;
    private DuanModel mDuanModel;

    public DuanPresenter(DuanView duanView) {
        mDuanView = duanView;
        mDuanModel = new DuanModel();
    }

    public void duan(String url){
        mDuanModel.duan(url, new DuanModel.HttpCall() {
            @Override
            public void getData(String s) {
                if(s!=null){
                    mDuanView.onSuccess(s);
                }else{
                    mDuanView.onFailer("失败");
                }
            }
        });
    }
}
