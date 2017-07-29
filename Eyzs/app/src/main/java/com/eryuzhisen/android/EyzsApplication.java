package com.eryuzhisen.android;


import android.support.multidex.MultiDexApplication;

/**
 * @actor:taotao
 * @DATE: 2017/7/29
 */

public class EyzsApplication extends MultiDexApplication {

    private static EyzsApplication eyzsApp;

    public static EyzsApplication getEyzsApp() {
        return eyzsApp;
    }

    private static void setEyzsApp(EyzsApplication eyzsApp) {
        EyzsApplication.eyzsApp = eyzsApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setEyzsApp(this);
    }
}
