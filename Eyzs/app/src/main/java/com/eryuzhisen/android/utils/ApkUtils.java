package com.eryuzhisen.android.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.na.mvp.log.NaLog;

/**
 * @actor:taotao
 * @DATE: 2017/8/22
 */

public class ApkUtils {

    public static String getAppVersionName(Context context) {
        String versionName = "";
        try {

            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
//            versioncode = pi.versionCode;
            if (StringUtils.isEmpty(versionName)) {
                return "";
            }
        } catch (Exception e) {
            NaLog.e("VersionInfo", "Exception", e);
        }
        return versionName;
    }
}
