package com.bw.qgs.qgs20181210.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.qgs.qgs20181210.R;
import com.bw.qgs.qgs20181210.adapter.DuanAdapter;
import com.bw.qgs.qgs20181210.bean.DuanUser;
import com.bw.qgs.qgs20181210.presenter.DuanPresenter;
import com.bw.qgs.qgs20181210.url.UrlUtil;
import com.bw.qgs.qgs20181210.view.DuanView;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TwoFragment extends Fragment implements DuanView {

    @BindView(R.id.recycle)
    XRecyclerView recycle;
    Unbinder unbinder;
    private DuanPresenter mDuanPresenter;
    private List<DuanUser.DataBean> mData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        unbinder = ButterKnife.bind(this, view);
        mDuanPresenter = new DuanPresenter(this);
        mDuanPresenter.duan(UrlUtil.PATH3);
        //刷新
        recycle.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        recycle.refreshComplete();
                    }
                },2000);
            }

            //加载
            @Override
            public void onLoadMore() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        recycle.loadMoreComplete();
                        mDuanPresenter.duan(UrlUtil.PATH3);
                    }
                },2000);
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onSuccess(String result) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recycle.setLayoutManager(linearLayoutManager);
        Gson gson = new Gson();
        DuanUser duanUser = gson.fromJson(result, DuanUser.class);
        mData = duanUser.getData();
        DuanAdapter duanAdapter = new DuanAdapter(getActivity(),mData);
        recycle.setAdapter(duanAdapter);
    }

    @Override
    public void onFailer(String msg) {

    }

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
}
