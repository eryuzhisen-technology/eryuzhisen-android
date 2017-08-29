package com.eryuzhisen.android.activity;

import android.app.Activity;
import android.content.Intent;

import com.na.mvp.log.NaLog;

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
    public static String login = "login";
    public static String login_signup = "login_signup";
    public static String register = "register";
    public static String reset_password = "reset_password";

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
            mActivityMap.put(login, LoginActivity.class);
            mActivityMap.put(login_signup, LoginSignupActivity.class);
            mActivityMap.put(register, RegisterActivity.class);
            mActivityMap.put(reset_password, ResetPasswordActivity.class);
        }
    }

    private Class getActivityClass(String name){
        return mActivityMap.get(name);
    }


    public void jumpToActivity(Activity activity, String nextActivityName) {
        NaLog.e(TAG, "jumpToActivity next=" + nextActivityName);
        Intent intent = new Intent(activity, getActivityClass(nextActivityName));
        activity.startActivity(intent);
    }
    
}
