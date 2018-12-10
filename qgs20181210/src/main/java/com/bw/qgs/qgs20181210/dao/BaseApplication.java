package com.bw.qgs.qgs20181210.dao;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.bw.qgs.qgs20181210.DaoMaster;

/**
 * date:2018/12/10    16:07
 * author:秦广帅(Lenovo)
 * fileName:BaseApplication
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        setupDatabase();
    }

    /*private void setupDatabase() {
        CommonOpenHelper.DevOpenHelper helper = new CommonOpenHelper.DevOpenHelper(this, "shop.db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(db);
        //获取Dao对象管理者
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoInstant() {
        return daoSession;
    }*/
}
