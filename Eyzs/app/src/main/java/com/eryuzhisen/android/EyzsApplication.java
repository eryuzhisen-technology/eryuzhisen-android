package com.eryuzhisen.android;


import com.na.mvp.NaApp;
import com.na.mvp.log.NaLog;

/**
 * @actor:taotao
 * @DATE: 2017/7/29
 */

public class EyzsApplication extends NaApp {
    @Override
    public void onCreate() {
        super.onCreate();
        NaLog.setIsDebug(true);
        NaLog.setLogLevel(NaLog.VERBOSE);
    }
}
