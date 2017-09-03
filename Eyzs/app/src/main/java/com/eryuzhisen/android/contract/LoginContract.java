package com.eryuzhisen.android.contract;

import com.na.mvp.contracts.NaContract;

import java.util.List;

/**
 * @actor:taotao
 * @DATE: 2017/7/29
 */

public interface LoginContract {
    interface Presenter extends NaContract.Presenter{
        List getData();
        void updateData();

        void login(String phone, String pwd);
    }

    interface View extends NaContract.View{
        void onUpdate();
        void onLogin(boolean isSuc);
    }

    interface Model extends NaContract.Model{
        List getData();
    }
}
