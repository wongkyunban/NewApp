package com.tisson.newapp;

import android.app.Application;

import com.tisson.newapp.cache.AppCache;

public class AppApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppCache.mContext = this;
    }
}
