package com.bw.qgs.qgs20181210;

import android.app.Application;
import android.os.Environment;

import com.bw.qgs.qgs20181210.url.HttpUtil;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

/**
 * date:2018/12/10    9:26
 * author:秦广帅(Lenovo)
 * fileName:App
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpUtil.init();
        //生成缓存磁盘
        DiskCacheConfig diskCacheConfig = DiskCacheConfig.newBuilder(this)
                .setBaseDirectoryName("image")
                .setBaseDirectoryPath(Environment.getExternalStorageDirectory())
                .build();
        //缓存
        ImagePipelineConfig imagePipelineConfig = ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(diskCacheConfig)
                .build();
        Fresco.initialize(this,imagePipelineConfig);
    }
}
