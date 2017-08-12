package com.eryuzhisen.android.presenter;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import com.eryuzhisen.android.contract.LauncherContract;
import com.eryuzhisen.android.model.LauncherModel;
import com.na.mvp.presenters.NaBasePresenter;
import com.na.mvp.rxbus.NaRxBus;

/**
 * @actor:taotao
 * @DATE: 2017/7/29
 */

public class LauncherPresenter extends NaBasePresenter<LauncherContract.View, LauncherModel> implements LauncherContract.Presenter{

    private static int LauncherMsg = 100;
    private static int LauncherTime = 1000;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            onLauncherFinish();
        }
    };

    @Override
    public void startLauncher(Activity activity) {
        handler.sendEmptyMessageDelayed(LauncherMsg, LauncherTime);

    }

    void onLauncherFinish(){
        this.view.onLauncherFinish();
    }

}
