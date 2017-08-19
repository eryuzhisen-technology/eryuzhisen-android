package com.eryuzhisen.android.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.eryuzhisen.android.EyzsApplication;

/**
 * Created by joy on 16/9/28.
 */
public class SharePrefenceUtil {

    private static final String EyzsConfig = "eyzs_config";
    private static final String EyzsConfig_WecomeOption = "wecome_option";

    public static boolean isWecomeOption() {
        SharedPreferences preferences = EyzsApplication.getApp().getSharedPreferences(EyzsConfig, Context.MODE_PRIVATE);
        if (preferences != null && preferences.contains(EyzsConfig_WecomeOption)) {
            return false;
        }
        return true;
    }

    public static void saveWecomeOption() {
        SharedPreferences preferences = EyzsApplication.getApp().getSharedPreferences(EyzsConfig, Context.MODE_PRIVATE);
        if (preferences != null) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(EyzsConfig_WecomeOption, true);
            editor.commit();
        }
    }
}
