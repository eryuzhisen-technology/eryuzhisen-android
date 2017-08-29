package com.eryuzhisen.android.presenter;

import com.eryuzhisen.android.contract.RegisterContract;
import com.eryuzhisen.android.event.PicVcodeEvent;
import com.eryuzhisen.android.model.RegisterModel;
import com.na.mvp.presenters.NaBasePresenter;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * @actor:taotao
 * @DATE: 2017/8/27
 */

public class RegisterPresenter extends NaBasePresenter<RegisterContract.View, RegisterModel> implements RegisterContract.Presenter{

    @Override
    public List getData() {
        return model.getData();
    }

    @Override
    public void updateData() {
        this.view.onUpdate();
    }

    @Override
    public boolean isRegisterNaRxBus() {
        return true;
    }

    @Subscribe
    public void onPicVcodeEvent(PicVcodeEvent event){
        if(event.isSuccess()) {
            model.setPicVcodeEvent(event);
            this.view.onUpdate();
        }
    }
}
