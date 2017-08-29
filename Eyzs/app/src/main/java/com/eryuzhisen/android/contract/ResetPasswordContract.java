package com.eryuzhisen.android.contract;

import com.na.mvp.contracts.NaContract;

import java.util.List;

/**
 * @actor:taotao
 * @DATE: 2017/7/29
 */

public interface ResetPasswordContract {
    interface Presenter extends NaContract.Presenter{
        List getData();
        void updateData();
    }

    interface View extends NaContract.View{
        void onUpdate();
    }

    interface Model extends NaContract.Model{
        List getData();
    }
}
