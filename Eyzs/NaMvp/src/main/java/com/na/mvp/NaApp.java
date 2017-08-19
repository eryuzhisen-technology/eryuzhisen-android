package com.na.mvp;

import android.support.multidex.MultiDexApplication;

import com.squareup.leakcanary.LeakCanary;

/**
 * @actor:taotao
 * @DATE: 2017/8/13
 */

public class NaApp extends MultiDexApplication {
    private static NaApp sApp;
    @Override
    public void onCreate() {
        super.onCreate();
        if (!LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            LeakCanary.install(this);
        }

    }

    public static NaApp getApp() {
        return sApp;
    }
}
