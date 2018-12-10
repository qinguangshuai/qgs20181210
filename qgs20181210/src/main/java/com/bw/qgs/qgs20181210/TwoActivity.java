package com.bw.qgs.qgs20181210;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.bw.qgs.qgs20181210.adapter.ProsenAdapter;
import com.bw.qgs.qgs20181210.bean.ProsenUser;
import com.bw.qgs.qgs20181210.presenter.OnePresenter;
import com.bw.qgs.qgs20181210.url.UrlUtil;
import com.bw.qgs.qgs20181210.view.OneView;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;

public class TwoActivity extends AppCompatActivity implements OneView {

    @BindView(R.id.fanhui)
    TextView fanhui;
    @BindView(R.id.xrecy)
    RecyclerView xrecy;
    private OnePresenter mOnePresenter;
    private ProsenUser.DataBean mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        ButterKnife.bind(this);
        mOnePresenter = new OnePresenter(this);
        mOnePresenter.utilUrl(UrlUtil.PATH2);
    }

    @Override
    public void onSuccess(String result) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        xrecy.setLayoutManager(linearLayoutManager);
        Gson gson = new Gson();
        ProsenUser prosenUser = gson.fromJson(result, ProsenUser.class);
        mData = prosenUser.getData();
        ProsenAdapter prosenAdapter = new ProsenAdapter(getApplicationContext(), mData);
        xrecy.setAdapter(prosenAdapter);
    }

    @Override
    public void onFailer(Call<String> call, Throwable t) {

    }

    @OnClick(R.id.fanhui)
    public void onViewClicked() {
        finish();
    }
}
