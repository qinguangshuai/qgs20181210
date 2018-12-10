package com.bw.qgs.qgs20181210;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bw.qgs.qgs20181210.fragment.FourFragment;
import com.bw.qgs.qgs20181210.fragment.OneFragment;
import com.bw.qgs.qgs20181210.fragment.ThreeFragment;
import com.bw.qgs.qgs20181210.fragment.TwoFragment;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottomtabbar)
    BottomTabBar bottomtabbar;
    @BindView(R.id.touxiang)
    TextView touxiang;
    private Unbinder mBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBind = ButterKnife.bind(this);
        bottomtabbar.init(getSupportFragmentManager())
                .addTabItem("推荐", R.drawable.shouye1, OneFragment.class)
                .addTabItem("段子", R.drawable.interactive1, TwoFragment.class)
                .addTabItem("发现", R.drawable.icon04, ThreeFragment.class)
                .addTabItem("视频", R.drawable.group1, FourFragment.class);
    }

    //解除绑定
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBind.unbind();
    }

    @OnClick(R.id.touxiang)
    public void onViewClicked() {
        startActivity(new Intent(MainActivity.this,TwoActivity.class));
    }
}
