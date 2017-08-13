package com.eryuzhisen.android.contract;

import com.na.mvp.contracts.NaContract;

import java.util.List;

/**
 * @actor:taotao
 * @DATE: 2017/8/12
 */

public interface MessageFragmentContract {
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
