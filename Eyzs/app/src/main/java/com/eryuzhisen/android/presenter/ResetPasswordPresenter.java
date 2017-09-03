package com.eryuzhisen.android.presenter;

import com.eryuzhisen.android.contract.ResetPasswordContract;
import com.eryuzhisen.android.logic.LogicLogin;
import com.eryuzhisen.android.logic.event.MsgVcodeEvent;
import com.eryuzhisen.android.logic.event.PicVcodeEvent;
import com.eryuzhisen.android.logic.event.ResetPwdEvent;
import com.eryuzhisen.android.model.ResetPasswordModel;
import com.na.mvp.presenters.NaBasePresenter;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * @actor:taotao
 * @DATE: 2017/8/27
 */

public class ResetPasswordPresenter extends NaBasePresenter<ResetPasswordContract.View, ResetPasswordModel> implements ResetPasswordContract.Presenter {
    private String picCode = null;
    private String picCodeId = null;

    @Override
    public boolean isRegisterNaRxBus() {
        return true;
    }

    @Override
    public List getData() {
        return model.getData();
    }

    @Override
    public void updateData() {
        this.view.onUpdate();
    }


    @Override
    public void resetPassword(String phone, String pwd, String msgCode) {
        LogicLogin.getInstance().resetPassword(phone, pwd, msgCode);
    }

    @Override
    public void getPicCode() {
        LogicLogin.getInstance().getPicVerifyCode();
    }

    @Override
    public void getMsgCode(String phone, String pcode) {
        String phoneNum = phone;
        LogicLogin.getInstance().getPhoneVerifyCode(phoneNum, "1", pcode, picCodeId);
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
    public void onResetPwdEvent(ResetPwdEvent event){
        if(this.view != null){
            this.view.onResetPwd(event.isSuccess());
        }
    }
}
