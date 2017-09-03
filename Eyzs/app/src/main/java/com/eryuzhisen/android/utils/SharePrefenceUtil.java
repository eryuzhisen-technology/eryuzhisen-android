package com.eryuzhisen.android.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.eryuzhisen.android.EyzsApplication;
import com.eryuzhisen.android.common.EyzsSession;
import com.eryuzhisen.android.common.EyzsUserInfo;

/**
 * Created by joy on 16/9/28.
 */
public class SharePrefenceUtil {

    private static final String EyzsConfig_File = "eyzs_config";
    private static final String EyzsConfig_WecomeOption = "wecome_option";

    private static final String EyzsSession_File = "eyzs_session";
    private static final String EyzsSession_UserToken = "user_token";
    private static final String EyzsSession_DeviceNo = "device_no";
    private static final String EyzsSession_EndTime = "end_time";
    private static final String EyzsSession_Uid = "uid";
    private static final String EyzsSession_NickName = "nick_name";
    private static final String EyzsSession_Avatar= "avatar";
    private static final String EyzsSession_Gender = "gender";
    private static final String EyzsSession_Signature = "signature";
    private static final String EyzsSession_Age = "age";

    public static boolean isWecomeOption() {
        SharedPreferences preferences = EyzsApplication.getApp().getSharedPreferences(EyzsConfig_File, Context.MODE_PRIVATE);
        if (preferences != null && preferences.contains(EyzsConfig_WecomeOption)) {
            return false;
        }
        return true;
    }

    public static void saveWecomeOption() {
        SharedPreferences preferences = EyzsApplication.getApp().getSharedPreferences(EyzsConfig_File, Context.MODE_PRIVATE);
        if (preferences != null) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(EyzsConfig_WecomeOption, true);
            editor.commit();
        }
    }

    public static void setSession(String token, String dn) {
        String t = token;
        if (StringUtils.isEmpty(token)) {
            t = "";
        }

        String d = dn;
        if(StringUtils.isEmpty(dn)){
            d = dn;
        }

        long endtime = System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7;

        SharedPreferences preferences = EyzsApplication.getApp().getSharedPreferences(EyzsSession_File, Context.MODE_PRIVATE);
        if (preferences != null) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(EyzsSession_UserToken, t);
            editor.putString(EyzsSession_DeviceNo, d);
            editor.putLong(EyzsSession_EndTime, endtime);
            editor.commit();
        }

        EyzsSession.getSession().refresh();
    }

    public static String getDeviceNo() {
        SharedPreferences preferences = EyzsApplication.getApp().getSharedPreferences(EyzsSession_File, Context.MODE_PRIVATE);
        String dn = "";
        if (preferences != null && preferences.contains(EyzsSession_DeviceNo)) {
            dn = preferences.getString(EyzsSession_DeviceNo, "");
        }
        
        return dn;
    }

    public static String getToken() {
        SharedPreferences preferences = EyzsApplication.getApp().getSharedPreferences(EyzsSession_File, Context.MODE_PRIVATE);
        String token = "";
        if (preferences != null && preferences.contains(EyzsSession_UserToken)) {
            token = preferences.getString(EyzsSession_UserToken, "");
        }
        return token;
    }

    public static long getEndTime() {
        SharedPreferences preferences = EyzsApplication.getApp().getSharedPreferences(EyzsSession_File, Context.MODE_PRIVATE);
        long endTime = 0L;
        if (preferences != null && preferences.contains(EyzsSession_EndTime)) {
            endTime = preferences.getLong(EyzsSession_EndTime, 0L);
        }
        return endTime;
    }

    public static void setUserInfo(EyzsUserInfo userInfo) {
        if(userInfo != null) {
            String uid = userInfo.getUid();
            if(StringUtils.isEmpty(uid)){
                uid = "";
            }

            String nickName = userInfo.getNickName();
            if(StringUtils.isEmpty(nickName)){
                nickName = "";
            }

            String gender = userInfo.getGender();
            if(StringUtils.isEmpty(gender)){
                gender = "";
            }

            String avatar = userInfo.getAvatar();
            if(StringUtils.isEmpty(avatar)){
                avatar = "";
            }

            String age = userInfo.getAge();
            if(StringUtils.isEmpty(age)){
                age = "";
            }

            String signature = userInfo.getAge();
            if(StringUtils.isEmpty(signature)) {
                signature = "";
            }

            SharedPreferences preferences = EyzsApplication.getApp().getSharedPreferences(EyzsSession_File, Context.MODE_PRIVATE);
            if (preferences != null) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(EyzsSession_Uid, uid);
                editor.putString(EyzsSession_NickName, nickName);
                editor.putString(EyzsSession_Gender, gender);
                editor.putString(EyzsSession_Avatar, avatar);
                editor.putString(EyzsSession_Age, age);
                editor.putString(EyzsSession_Signature, signature);
                editor.commit();
            }

            EyzsSession.getSession().refreshUser();
        }
    }

    public static EyzsUserInfo getUserInfo(){
        EyzsUserInfo info = new EyzsUserInfo();
        SharedPreferences preferences = EyzsApplication.getApp().getSharedPreferences(EyzsSession_File, Context.MODE_PRIVATE);
        if (preferences != null) {
            String uid = "";
            if(preferences.contains(EyzsSession_Uid)){
                uid = preferences.getString(EyzsSession_Uid, "");
            }
            info.setUid(uid);

            String nickName = "";
            if(preferences.contains(EyzsSession_NickName)){
                nickName = preferences.getString(EyzsSession_NickName, "");
            }
            info.setNickName(nickName);

            String avatar = "";
            if(preferences.contains(EyzsSession_Avatar)){
                avatar = preferences.getString(EyzsSession_Avatar, "");
            }
            info.setAvatar(avatar);

            String signature = "";
            if(preferences.contains(EyzsSession_Signature)){
                signature = preferences.getString(EyzsSession_Signature, "");
            }
            info.setSignature(signature);

            String age = "";
            if(preferences.contains(EyzsSession_Age)){
                age = preferences.getString(EyzsSession_Age, "");
            }
            info.setAge(age);

            String gender = "";
            if(preferences.contains(EyzsSession_Gender)){
                gender = preferences.getString(EyzsSession_Gender, "");
            }
            info.setGender(gender);
        }

        return info;
    }

    public static void clearSession() {
        SharedPreferences preferences = EyzsApplication.getApp().getSharedPreferences(EyzsSession_File, Context.MODE_PRIVATE);
        if (preferences != null) {
            preferences.edit().clear().commit();
        }
    }
}
