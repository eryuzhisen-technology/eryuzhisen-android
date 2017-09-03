package com.eryuzhisen.android.presenter;

import com.eryuzhisen.android.contract.RegisterContract;
import com.eryuzhisen.android.logic.LogicLogin;
import com.eryuzhisen.android.logic.event.MsgVcodeEvent;
import com.eryuzhisen.android.logic.event.PicVcodeEvent;
import com.eryuzhisen.android.logic.event.RegisterEvent;
import com.eryuzhisen.android.model.RegisterModel;
import com.na.mvp.presenters.NaBasePresenter;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * @actor:taotao
 * @DATE: 2017/8/27
 */

public class RegisterPresenter extends NaBasePresenter<RegisterContract.View, RegisterModel> implements RegisterContract.Presenter{

    private String picCode = null;
    private String picCodeId = null;
    @Override
    public List getData() {
        return model.getData();
    }

    @Override
    public void updateData() {
        this.view.onUpdate();
    }

    @Override
    public void register(String phone, String pwd, String msgCode) {
       LogicLogin.getInstance().register(phone, pwd, msgCode);
    }

    @Override
    public void getMsgCode(String phone, String pcode) {
        String phoneNum = phone;
        LogicLogin.getInstance().getPhoneVerifyCode(phoneNum, "0", pcode, picCodeId);
    }

    @Override
    public void getPicCode() {
        LogicLogin.getInstance().getPicVerifyCode();
    }

    @Override
    public boolean isRegisterNaRxBus() {
        return true;
    }

    @Subscribe
    public void onPicVcodeEvent(PicVcodeEvent event){
        byte[] img = null;
        if(event.isSuccess()) {
//            model.setPicVcodeEvent(event);
//            this.view.onUpdate();
            picCode = event.getPicVcode();
            picCodeId = event.getVcodeId();
            img = event.getPicVcodeImg();
        } else {
            picCode = null;
            picCodeId = null;
        }

        if(this.view != null){
            this.view.onPicVcode(img);
        }
    }

    @Subscribe
    public  void onMsgVcodeEvent(MsgVcodeEvent event){
        if(this.view != null){
            this.view.onMsgVcode(event.isSuccess());
        }
    }

    @Subscribe
    public void onRegisterEvent(RegisterEvent event){
        if(this.view != null){
            this.view.onRegister(event.isSuccess());
        }
    }
}
