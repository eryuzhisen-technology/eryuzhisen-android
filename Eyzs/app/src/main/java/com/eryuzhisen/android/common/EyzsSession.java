package com.eryuzhisen.android.common;

import com.eryuzhisen.android.utils.SharePrefenceUtil;
import com.eryuzhisen.android.utils.StringUtils;
import com.na.mvp.log.NaLog;

/**
 * @actor:taotao
 * @DATE: 2017/8/30
 */

public final class EyzsSession {
    private static final String TAG = "EyzsSession";
    public static EyzsSession session = new EyzsSession();

    private String deviceNo;
    private String token;
    private long endTime;
    private EyzsUserInfo userInfo;

    private EyzsSession() {
        init();
    }

    private void init() {
        refresh();
        refreshUser();
    }

    public static EyzsSession getSession() {
        return session;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public String getToken() {
        return token;
    }

    public EyzsUserInfo getUserInfo() {
        return userInfo;
    }

    public boolean isExpire() {
        boolean flag = false;
        if (!StringUtils.isEmpty(token) && !isOverEndTime()) {
            flag = true;
        }
        return flag;
    }

    private boolean isOverEndTime() {
        long now = System.currentTimeMillis();
        if (now > endTime) {
            return true;
        }
        return false;
    }

    public void refresh() {
        token = SharePrefenceUtil.getToken();
        deviceNo = SharePrefenceUtil.getDeviceNo();
        endTime = SharePrefenceUtil.getEndTime();
    }

    public void refreshUser() {
        userInfo = SharePrefenceUtil.getUserInfo();
    }

    public boolean isLogined() {
        boolean flag = isExpire();
        NaLog.d(TAG, "isLogined " + flag);
        return flag;
    }

    public void logout() {
        SharePrefenceUtil.clearSession();
    }

    public String getUserId() {
        String uid = "";
        if(userInfo != null){
            uid = userInfo.getUid();
        }

        if(StringUtils.isEmpty(uid)){
            uid = "";
        }
        return uid;
    }
}
