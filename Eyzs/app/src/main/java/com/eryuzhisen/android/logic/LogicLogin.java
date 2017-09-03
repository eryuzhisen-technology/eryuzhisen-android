package com.eryuzhisen.android.logic;

import android.os.Message;

import com.eryuzhisen.android.common.EyzsUserInfo;
import com.eryuzhisen.android.logic.event.LoginEvent;
import com.eryuzhisen.android.logic.event.PicVcodeEvent;
import com.eryuzhisen.android.logic.api.EyzsApi;
import com.eryuzhisen.android.logic.api.UrlData;
import com.eryuzhisen.android.logic.request.PackageLogin;
import com.eryuzhisen.android.logic.request.PackagePhoneVerifyCode;
import com.eryuzhisen.android.logic.request.PackagePicVerifyCode;
import com.eryuzhisen.android.logic.request.PackageRegister;
import com.eryuzhisen.android.logic.request.PackageResetPassword;
import com.eryuzhisen.android.utils.SharePrefenceUtil;
import com.eryuzhisen.android.utils.StringUtils;
import com.na.mvp.net.CoreHandler;
import com.na.mvp.net.OkHttp;
import com.na.mvp.net.request.LogicBaseReq;
import com.na.mvp.rxbus.NaRxBus;

/**
 * @actor:taotao
 * @DATE: 2017/8/22
 */

public class LogicLogin extends CoreHandler {
    private static LogicLogin ourInstance = new LogicLogin();
    private boolean isLogin = false;
    private boolean isRegister = false;
    private boolean isGetPicVcode = false;
    private boolean isGetMsgVcode = false;
    private long getMsgStartTime = 0;
    private boolean isResetPassword = false;

    private LogicLogin() {

    }

    public static LogicLogin getInstance() {
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
        switch (msg.what) {
            case Constants.CommandLogin: {
                isLogin = false;
                boolean isSuc = false;
                if(msg.obj != null) {
                    PackageLogin.EyzsLoginResp resp = (PackageLogin.EyzsLoginResp) msg.obj;
                    isSuc = resp.isSuccess();
                    SharePrefenceUtil.setSession(resp.getToken(), resp.getDevice_no());
                    if(!StringUtils.isEmpty(resp.getUid()) && resp.getUser() != null){
                        String uid = resp.getUid();
                        String nickName = resp.getUser().getNick_name();
                        String avatar = resp.getUser().getAvatar_url();
                        String gender = resp.getUser().getGender();
                        String deviceNo = resp.getUser().getDevice_no();
                        String signature = resp.getUser().getSignature();
                        String age = resp.getUser().getC_age();
                        EyzsUserInfo info = new EyzsUserInfo(uid, nickName, gender, avatar);
                        info.setAge(age);
                        info.setDeviceNo(deviceNo);
                        info.setSignature(signature);
                        SharePrefenceUtil.setUserInfo(info);
                    }

                }
                LoginEvent event = new LoginEvent();
                event.setSuccess(isSuc);
                NaRxBus.getRxBus().post(event);
                break;
            }
            case Constants.CommandRegister: {
                isRegister = false;
                PackageRegister.EyzsRegisterResp resp = (PackageRegister.EyzsRegisterResp) msg.obj;
                break;
            }
            case Constants.CommandPicVerifyCode: {
                isGetPicVcode = false;
                PackagePicVerifyCode.EyzsPicVerifyCodeResp resp = null;
                if (msg.obj != null) {
                    resp = (PackagePicVerifyCode.EyzsPicVerifyCodeResp) msg.obj;
                }

                PicVcodeEvent event = new PicVcodeEvent();
                if (resp != null && resp.isSuccess()) {
                    event.setSuccess(true);
                    event.setPicVcode(resp.getPic_vcode());
                    event.setVcodeId(resp.getPic_vid());

                }
                NaRxBus.getRxBus().post(event);
                break;
            }
            case Constants.CommandPhoneVerifyCode: {
                isGetMsgVcode = false;
                PackagePhoneVerifyCode.EyzsPhoneVerifyCodeResp resp = (PackagePhoneVerifyCode.EyzsPhoneVerifyCodeResp) msg.obj;
                break;
            }
            case Constants.CommandResetPassword: {
                isResetPassword = false;
                PackageResetPassword.EyzsResetPasswordResp resp = (PackageResetPassword.EyzsResetPasswordResp) msg.obj;
                break;
            }
            default: {
                break;
            }
        }
    }

    @Override
    public void onHttpResponse(LogicBaseReq req, Object resp) {
        if (req != null) {
            switch (req.getCommandId()) {
                case Constants.CommandLogin:
                case Constants.CommandRegister:
                case Constants.CommandPhoneVerifyCode:
                case Constants.CommandPicVerifyCode:
                case Constants.CommandResetPassword: {
                    sendToMainThread(req.getCommandId(), 0, 0, resp);
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }

    public void getPicVerifyCode() {
        if (isGetPicVcode) {
            return;
        }
        isGetPicVcode = true;
        UrlData data = EyzsApi.getEyzsApi().getApiUrlData(EyzsApi.UrlDataKeyPicVerifyCode);

        PackagePicVerifyCode.EyzsPicVerifyCodeReq req = new PackagePicVerifyCode.EyzsPicVerifyCodeReq(data, Constants.CommandPicVerifyCode);
        OkHttp.getInstance().request(req);
    }

    public void getPhoneVerifyCode(String phoneNum, String type, String picVcode, String picVid) {

        if (isGetMsgVcode) {
            return;
        }

        if (StringUtils.isEmpty(phoneNum)) {
            return;
        }

        if (StringUtils.isEmpty(picVcode)) {
            return;
        }

        if (StringUtils.isEmpty(picVid)) {
            return;
        }

        if (StringUtils.isEmpty(type)) {
            return;
        }

        isGetMsgVcode = true;

        UrlData data = EyzsApi.getEyzsApi().getApiUrlData(EyzsApi.UrlDataKeyPhoneVerifyCode);

        PackagePhoneVerifyCode.EyzsPhoneVerifyCodeReq req = new PackagePhoneVerifyCode.EyzsPhoneVerifyCodeReq(data, Constants.CommandPhoneVerifyCode);
        req.setPhoneNum(phoneNum);
        req.setVerifyType(type);
        req.setPicVcode(picVcode);
        req.setPicVid(picVid);
        OkHttp.getInstance().request(req);
    }

    public void login(String phone, String password, String pvid, String pvcode) {
        if (isLogin) {
            return;
        }

        if (StringUtils.isEmpty(phone)) {
            return;
        }

        isLogin = true;

        UrlData data = EyzsApi.getEyzsApi().getApiUrlData(EyzsApi.UrlDataKeyLogin);

        PackageLogin.EyzsLoginReq req = new PackageLogin.EyzsLoginReq(data, Constants.CommandLogin);
        req.setPhone_num(phone);
        req.setPassword(password);
        req.setDevice_no(SharePrefenceUtil.getDeviceNo());
        if (!StringUtils.isEmpty(pvid) && !StringUtils.isEmpty(pvcode)) {
            req.setPic_vid(pvid);
            req.setPic_vcode(pvcode);
        }
        OkHttp.getInstance().request(req);
    }

    public void register(String phone, String password, String phoneVcode) {
        if (isRegister) {
            return;
        }

        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(password) || StringUtils.isEmpty(phoneVcode)) {
            return;
        }

        isRegister = true;

        UrlData data = EyzsApi.getEyzsApi().getApiUrlData(EyzsApi.UrlDataKeyLogin);

        PackageRegister.EyzsRegisterReq req = new PackageRegister.EyzsRegisterReq(data, Constants.CommandRegister);
        req.setPhone_num(phone);
        req.setPassword(password);
        req.setDevice_no(SharePrefenceUtil.getDeviceNo());
        req.setInvite_code(null);
        req.setPhone_vcode(phoneVcode);
        OkHttp.getInstance().request(req);
    }

    public void resetPassword(String phone, String password, String phoneVcode) {
        if (isResetPassword) {
            return;
        }

        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(password) || StringUtils.isEmpty(phoneVcode)) {
            return;
        }

        isResetPassword = true;

        UrlData data = EyzsApi.getEyzsApi().getApiUrlData(EyzsApi.UrlDataKeyResetPassword);

        PackageResetPassword.EyzsResetPasswordReq req = new PackageResetPassword.EyzsResetPasswordReq(data, Constants.CommandResetPassword);
        req.setPhone_num(phone);
        req.setPassword(password);
        req.setPhone_vcode(phoneVcode);
        OkHttp.getInstance().request(req);
    }

}
