package com.bw.qgs.qgs20181210.dao;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * date:2018/12/10    15:55
 * author:秦广帅(Lenovo)
 * fileName:CommonOpenHelper
 */
public class CommonOpenHelper extends SQLiteOpenHelper {

    private static CommonOpenHelper helper;

    public static CommonOpenHelper getInstance(Context context){
        if(helper == null){
            helper = new CommonOpenHelper(context,"common.db",null,1);
        }
        return  helper;
    }

    public CommonOpenHelper(Context context,String name,SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table love("+"id integer primary key autoincrement,"+"icon varchar,"+"createtime varchar,"+"content varchar,"+"ImageURI varchar"+")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
