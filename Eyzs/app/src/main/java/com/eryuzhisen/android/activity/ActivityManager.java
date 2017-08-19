package com.eryuzhisen.android.activity;

import android.app.Activity;
import android.content.Intent;

import com.na.mvp.log.EyzsLog;

import java.util.HashMap;
import java.util.Map;

/**
 * @actor:taotao
 * @DATE: 2017/7/29
 */

public final class ActivityManager {

    private static final String TAG = "ActivityManager";
    public static String launcher = "launcher";
    public static String main = "main";
    public static String wecome = "wecome";

    private static ActivityManager sInstance;
    private static Map<String, Class> mActivityMap = null;

    public static ActivityManager getInstance() {

        if(sInstance == null){
            synchronized (ActivityManager.class) {
                if(sInstance == null) {
                    sInstance = new ActivityManager();
                    sInstance.init();
                }
            }
        }
        return sInstance;
    }

    private void init(){
        if(mActivityMap == null) {
            mActivityMap = new HashMap<String, Class>();
            mActivityMap.put(launcher, LauncherActivity.class);
            mActivityMap.put(main, MainActivity.class);
            mActivityMap.put(wecome, WecomeActivity.class);
        }
    }

    private Class getActivityClass(String name){
        return mActivityMap.get(name);
    }


    public void jumpToActivity(Activity activity, String nextActivityName) {
        EyzsLog.e(TAG, "jumpToActivity next=" + nextActivityName);
        Intent intent = new Intent(activity, getActivityClass(nextActivityName));
        activity.startActivity(intent);
    }
    
}
