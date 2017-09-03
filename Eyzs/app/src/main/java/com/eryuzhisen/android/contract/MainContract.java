package com.eryuzhisen.android.contract;

import android.app.Activity;

import com.na.mvp.contracts.NaContract;

/**
 * @actor:taotao
 * @DATE: 2017/7/29
 */

public interface MainContract {
    interface Presenter extends NaContract.Presenter{
        void checkLogin(Activity activity);
    }

    interface View extends NaContract.View{

    }

    interface Model extends NaContract.Model{

    }
}
