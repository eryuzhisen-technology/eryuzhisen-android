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
    private static final String EyzsConfig_UserToken = "user_token";
    private static final String EyzsConfig_DeviceNo = "device_no";

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

    public static String getToken() {
        SharedPreferences preferences = EyzsApplication.getApp().getSharedPreferences(EyzsConfig, Context.MODE_PRIVATE);
        String token = "";
        if (preferences != null && preferences.contains(EyzsConfig_UserToken)) {
            token = preferences.getString(EyzsConfig_UserToken, "");
        }
        return token;
    }

    public static void setToken(String token) {
        if (StringUtils.isEmpty(token)) {
            return;
        }
        SharedPreferences preferences = EyzsApplication.getApp().getSharedPreferences(EyzsConfig, Context.MODE_PRIVATE);
        if (preferences != null) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(EyzsConfig_UserToken, token);
            editor.commit();
        }
    }

    public static String getDeviceNo() {
        SharedPreferences preferences = EyzsApplication.getApp().getSharedPreferences(EyzsConfig, Context.MODE_PRIVATE);
        String dn = "";
        if (preferences != null && preferences.contains(EyzsConfig_DeviceNo)) {
            dn = preferences.getString(EyzsConfig_DeviceNo, "");
        }

        if (StringUtils.isEmpty(dn)) {
            dn = "eyzs-test-device-no";
        }

        return dn;
    }

}
