package com.bw.qgs.qgs20181105;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;

public class MainActivity extends AppCompatActivity implements Lottery.donghua {

    private Toolbar mToolbar;
    private Animation mAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找控件
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        //显示标题
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        //显示左侧按钮
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //点击退出
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });



        Lottery lottery = new Lottery(getApplicationContext());
        lottery.HttpDong(new Lottery.donghua() {
            @Override
            public Void dong(View view) {
                return null;
            }
        });
       /* lottery.HttpDong(new Lottery.donghua() {
            @Override
            public Void dong(View view) {
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //时间
                        mAnimation.setDuration(3000);
                        mAnimation.setFillAfter(true);
                        //设置重复模式
                        mAnimation.setRepeatMode(Animation.RESTART);
                        //设置重复次数
                        mAnimation.setRepeatCount(-1);
                        //设置xml属性
                        mAnimation.setInterpolator(new LinearInterpolator());
                    }
                });
                return null;
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public Void dong(View view) {
        return null;
    }

    /*@Override
    public Void dong(View view) {
        //时间
        mAnimation.setDuration(3000);
        mAnimation.setFillAfter(true);
        //设置重复模式
        mAnimation.setRepeatMode(Animation.RESTART);
        //设置重复次数
        mAnimation.setRepeatCount(-1);
        //设置xml属性
        mAnimation.setInterpolator(new LinearInterpolator());
        return null;
    }*/
}
