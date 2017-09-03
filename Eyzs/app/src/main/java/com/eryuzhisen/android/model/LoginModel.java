package com.eryuzhisen.android.model;

import com.eryuzhisen.android.R;
import com.eryuzhisen.android.contract.LoginContract;
import com.eryuzhisen.android.logic.event.PicVcodeEvent;
import com.eryuzhisen.android.logic.LogicLogin;
import com.eryuzhisen.android.model.entity.LoginButtonEntity;
import com.eryuzhisen.android.model.entity.LoginTextEntity;
import com.eryuzhisen.android.model.entity.PasswordEntity;
import com.eryuzhisen.android.model.entity.PhoneEntity;
import com.eryuzhisen.android.model.entity.PicVcodeEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @actor:taotao
 * @DATE: 2017/8/27
 */

public class LoginModel implements LoginContract.Model {

    private PhoneEntity phoneItem;
    private PasswordEntity passwordItem;
    private LoginTextEntity loginTexItem;
    private PicVcodeEntity picVcodeItem;
    private LoginButtonEntity loginButtonItem;

    @Override
    public List getData() {
        List data = new ArrayList();
        if(phoneItem == null){
            phoneItem = new PhoneEntity();
        }
        data.add(phoneItem);

        if(passwordItem == null){
            passwordItem = new PasswordEntity();
        }
        data.add(passwordItem);

        if(loginTexItem == null){
            loginTexItem = new LoginTextEntity();
            loginTexItem.setTextResId(R.string.forgot_password);
            loginTexItem.setForgotPwd(true);
        }
        data.add(loginTexItem);

        if(picVcodeItem != null){
            data.add(picVcodeItem);
        }

        if(loginButtonItem == null) {
            loginButtonItem = new LoginButtonEntity();
            loginButtonItem.setTextResId(R.string.immediately_login);
            loginButtonItem.setListener(new LoginButtonEntity.Listener() {
                @Override
                public void onClick() {
                    String phone = phoneItem.getPhoneNum();
                    String pwd = passwordItem.getPassword();
                    String picCode = null;
                    String picodeId = null;
                    if(picVcodeItem != null){
                        picCode = picVcodeItem.getPicVcode();
                        picodeId = picVcodeItem.getPicVcodeId();
                    }
                    LogicLogin.getInstance().login(phone,pwd,picodeId,picCode);
                }
            });
        }
        data.add(loginButtonItem);
        return data;
    }

    public void setPicVcodeEvent(PicVcodeEvent picVcodeEvent) {
        if(picVcodeItem == null){
            picVcodeItem = new PicVcodeEntity();
            picVcodeItem.setListener(new PicVcodeEntity.Listener() {
                @Override
                public void onGetVcode() {
                    LogicLogin.getInstance().getPicVerifyCode();
                }
            });
        }
        picVcodeItem.setPicVcodeEvent(picVcodeEvent);
    }
}
