package com.eryuzhisen.android.presenter;

import com.eryuzhisen.android.contract.LoginContract;
import com.eryuzhisen.android.logic.LogicLogin;
import com.eryuzhisen.android.logic.event.LoginEvent;
import com.eryuzhisen.android.logic.event.PicVcodeEvent;
import com.eryuzhisen.android.model.LoginModel;
import com.na.mvp.presenters.NaBasePresenter;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * @actor:taotao
 * @DATE: 2017/8/27
 */

public class LoginPresenter extends NaBasePresenter<LoginContract.View, LoginModel> implements LoginContract.Presenter{

    @Override
    public List getData() {
        return model.getData();
    }

    @Override
    public void updateData() {
        this.view.onUpdate();
    }

    @Override
    public void login(String phone, String pwd) {
        LogicLogin.getInstance().login(phone,pwd, null, null);
    }

    @Subscribe
    public void onPicVcodeEvent(PicVcodeEvent event){
        if(event.isSuccess()) {
            model.setPicVcodeEvent(event);
            this.view.onUpdate();
        }
    }

    @Override
    public boolean isRegisterNaRxBus() {
        return true;
    }

    @Subscribe
    public void onLogin(LoginEvent event){
       this.view.onLogin(event.isSuccess());
    }
}
