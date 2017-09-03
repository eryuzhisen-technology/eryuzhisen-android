package com.eryuzhisen.android.presenter;


import android.app.Activity;

import com.eryuzhisen.android.activity.ActivityManager;
import com.eryuzhisen.android.common.EyzsSession;
import com.eryuzhisen.android.contract.MainContract;
import com.eryuzhisen.android.model.MainModel;
import com.na.mvp.presenters.NaBasePresenter;

/**
 * @actor:taotao
 * @DATE: 2017/7/29
 */

public class MainPresenter extends NaBasePresenter<MainContract.View, MainModel> implements MainContract.Presenter{

    @Override
    public void checkLogin(Activity activity) {
        if(!EyzsSession.getSession().isLogined()){
//            ActivityManager.getInstance().jumpToActivity(activity, ActivityManager.login);
        }
    }
}
