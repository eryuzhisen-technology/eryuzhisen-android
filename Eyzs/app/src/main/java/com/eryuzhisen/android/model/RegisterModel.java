package com.eryuzhisen.android.model;

import com.eryuzhisen.android.R;
import com.eryuzhisen.android.contract.RegisterContract;
import com.eryuzhisen.android.event.PicVcodeEvent;
import com.eryuzhisen.android.logic.LogicLogin;
import com.eryuzhisen.android.model.entity.LoginButtonEntity;
import com.eryuzhisen.android.model.entity.LoginTextEntity;
import com.eryuzhisen.android.model.entity.MsgVcodeEntity;
import com.eryuzhisen.android.model.entity.PasswordEntity;
import com.eryuzhisen.android.model.entity.PhoneEntity;
import com.eryuzhisen.android.model.entity.PicVcodeEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @actor:taotao
 * @DATE: 2017/8/27
 */

public class RegisterModel implements RegisterContract.Model{

    private PhoneEntity phoneItem;
    private PicVcodeEntity picVcodeItem;
    private MsgVcodeEntity msgVcodeItem;
    private PasswordEntity passwordItem;
    private LoginTextEntity loginTexItem;
    private LoginButtonEntity loginButtonItem;

    @Override
    public List getData() {
        List data = new ArrayList();
        if(phoneItem == null){
            phoneItem = new PhoneEntity();
        }
        data.add(phoneItem);

        if(picVcodeItem == null){
            picVcodeItem = new PicVcodeEntity();
            picVcodeItem.setListener(new PicVcodeEntity.Listener() {
                @Override
                public void onGetVcode() {
                    LogicLogin.getInstance().getPicVerifyCode();
                }
            });
        }
        data.add(picVcodeItem);

        if(msgVcodeItem == null){
            msgVcodeItem = new MsgVcodeEntity();
            msgVcodeItem.setListener(new MsgVcodeEntity.Listener() {
                @Override
                public void onGetVcode() {
                    String phoneNum = phoneItem.getPhoneNum();
                    String picCode = picVcodeItem.getPicVcode();
                    String picCodeId = picVcodeItem.getPicVcodeId();
                    LogicLogin.getInstance().getPhoneVerifyCode(phoneNum, "0", picCode, picCodeId);
                }
            });
        }
        data.add(msgVcodeItem);

        if(passwordItem == null){
            passwordItem = new PasswordEntity();
        }
        data.add(passwordItem);

        if(loginTexItem == null){
            loginTexItem = new LoginTextEntity();
            loginTexItem.setTextResId(R.string.register_protocol);
        }
        data.add(loginTexItem);

        if(loginButtonItem == null) {
            loginButtonItem = new LoginButtonEntity();
            loginButtonItem.setTextResId(R.string.immediately_register);
            loginButtonItem.setListener(new LoginButtonEntity.Listener() {
                @Override
                public void onClick() {
                    String phoneNum = phoneItem.getPhoneNum();
                    String password = passwordItem.getPassword();
                    String picCode = picVcodeItem.getPicVcode();
                    LogicLogin.getInstance().register(phoneNum, password, picCode);
                }
            });
        }
        data.add(loginButtonItem);
        return data;
    }

    @Override
    public void setPicVcodeEvent(PicVcodeEvent event) {
        picVcodeItem.setPicVcodeEvent(event);
    }


}
