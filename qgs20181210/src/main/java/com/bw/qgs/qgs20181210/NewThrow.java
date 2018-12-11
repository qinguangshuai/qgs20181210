package com.bw.qgs.qgs20181210;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * date:2018/12/11    11:11
 * author:秦广帅(Lenovo)
 * fileName:NewThrow
 */
public class NewThrow {
    public  boolean isNetWork(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo!=null){
            return  true;
        }
        return false;
    }
}
