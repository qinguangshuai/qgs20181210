package com.bw.qgs.qgs20181210;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * date:2018/12/10    11:28
 * author:秦广帅(Lenovo)
 * fileName:DaoMaster
 */
public class DaoMaster extends SQLiteOpenHelper {
    public DaoMaster(Context context,String name,SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /*public DaoMaster(SQLiteDatabase db) {
        super(db);
    }*/

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static class DevOpenHelper {
        public DevOpenHelper(MyGDApplication myGDApplication, String s, Object o) {
        }

        public SQLiteDatabase getWritableDatabase() {
            return null;
        }
    }
}
