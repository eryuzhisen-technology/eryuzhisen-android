package com.eryuzhisen.android.logic;

import android.os.Message;

import com.eryuzhisen.android.logic.api.EyzsApi;
import com.eryuzhisen.android.logic.api.UrlData;
import com.eryuzhisen.android.logic.request.PackageUserInfo;
import com.eryuzhisen.android.utils.StringUtils;
import com.na.mvp.net.CoreHandler;
import com.na.mvp.net.OkHttp;
import com.na.mvp.net.request.LogicBaseReq;
import com.na.mvp.rxbus.NaRxBus;

/**
 * @actor:taotao
 * @DATE: 2017/8/30
 */

public class LoginUser extends CoreHandler {

    private static LoginUser ourInstance = new LoginUser();

    private LoginUser() {

    }

    public static LoginUser getInstance() {
        if (!NaRxBus.getRxBus().isRegistered(ourInstance)) {
            NaRxBus.getRxBus().register(ourInstance);
        }
        return ourInstance;
    }

    @Override
    public void onAsynThread(Message msg) {

    }

    @Override
    public void onMainThread(Message msg) {
        switch (msg.what){
            case Constants.CommamdGetUserInfo:{
                break;
            }
            default:{
                break;
            }
        }
    }

    @Override
    public void onHttpResponse(LogicBaseReq req, Object resp) {
        if (req != null) {
            switch (req.getCommandId()) {
                case Constants.CommamdGetUserInfo: {
                    sendToMainThread(req.getCommandId(), 0, 0, resp);
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }

    public void getUserInfo(String uid) {
        if (StringUtils.isEmpty(uid)) {
            return;
        }
        UrlData data = EyzsApi.getEyzsApi().getApiUrlData(EyzsApi.UrlDataKeyGetUserInfo);

        PackageUserInfo.EyzsUserInfoReq req = new PackageUserInfo.EyzsUserInfoReq(data, Constants.CommamdGetUserInfo);
        req.setUserId(uid);
        OkHttp.getInstance().request(req);
    }
}
