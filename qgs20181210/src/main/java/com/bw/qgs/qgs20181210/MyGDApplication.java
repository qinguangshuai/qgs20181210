package com.bw.qgs.qgs20181210;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

/**
 * date:2018/12/10    11:19
 * author:秦广帅(Lenovo)
 * fileName:MyGDApplication
 */
public class MyGDApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //设置数据库
        setDataBase();
    }

    private void setDataBase() {
        //创建数据库
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "topnews.db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        //获取数据库对象
    }
}
