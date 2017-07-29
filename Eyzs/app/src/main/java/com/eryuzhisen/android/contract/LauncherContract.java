package com.eryuzhisen.android.contract;

import android.app.Activity;

import com.na.mvp.contracts.NaContract;

/**
 * @actor:taotao
 * @DATE: 2017/7/29
 */

public interface LauncherContract {
    interface Presenter extends NaContract.Presenter{
        void startLauncher(Activity activity);
    }

    interface View extends NaContract.View{
        void onLauncherFinish();
    }

    interface Model extends NaContract.Model{

    }
}
