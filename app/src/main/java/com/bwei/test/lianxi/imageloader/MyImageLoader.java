package com.bwei.test.lianxi.imageloader;

import android.app.Application;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by zhangjie on 2016/11/10.
 */
public class MyImageLoader extends Application {

    @Override
    public void onCreate() {
        ImageLoaderConfiguration configuration=ImageLoaderConfiguration.createDefault(this);
        ImageLoader.getInstance().init(configuration);
        super.onCreate();
    }
}
