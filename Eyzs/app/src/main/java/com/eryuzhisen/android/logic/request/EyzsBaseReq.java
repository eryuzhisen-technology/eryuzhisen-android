package com.eryuzhisen.android.logic.request;

import com.eryuzhisen.android.EyzsApplication;
import com.eryuzhisen.android.logic.api.UrlData;
import com.eryuzhisen.android.utils.ApkUtils;
import com.eryuzhisen.android.utils.SharePrefenceUtil;
import com.na.mvp.net.request.LogicBaseReq;

import java.util.Map;

/**
 * @actor:taotao
 * @DATE: 2017/8/19
 */

public abstract class EyzsBaseReq extends LogicBaseReq {
    private static final long serialVersionUID = -1689316440370442557L;
    public static final String ContentType = "application/json;charset=UTF-8";
    protected UrlData mUrlData;

    public EyzsBaseReq(UrlData urlData, int command) {
        this.commandId = command;
        this.mUrlData = urlData;
        initHeaders();
    }

    public EyzsBaseReq() {
        initHeaders();
    }

    //  "token":"xxxxx"//***校验用户是否登陆过期***
    //  "client_type":"1",//客户端类型 1 ios 2 android 3 web
    //  "client_version":"xxxxxx",//后续升级版本使用
    private void initHeaders() {
        String token = SharePrefenceUtil.getToken();
        String clientType = "2";
        String clientVersion = ApkUtils.getAppVersionName(EyzsApplication.getApp());

        Map headers = getHeaders();

        if (headers != null) {
            headers.put("token", token);
            headers.put("client_type", clientType);
            headers.put("client_version", clientVersion);
        }
    }

    @Override
    public String getUrl() {
        String url = null;
        if (mUrlData != null) {
            url = mUrlData.getUrl();
        }
        return url;
    }

    @Override
    public int getMethod() {
        int method = 0;
        if (mUrlData != null) {
            method = mUrlData.getMethod();
        }
        return method;
    }

    @Override
    public String getHttpEntity() {
        return null;
    }

    @Override
    public String getContentType() {
        return ContentType;
    }
}
