package com.eryuzhisen.android.presenter;


import com.eryuzhisen.android.contract.FindFragmentContract;
import com.eryuzhisen.android.model.FindFragmentModel;
import com.na.mvp.presenters.NaBasePresenter;

/**
 * @actor:taotao
 * @DATE: 2017/7/29
 */

public class FindFragmentPresenter extends NaBasePresenter<FindFragmentContract.View, FindFragmentModel> implements FindFragmentContract.Presenter {
    @Override
    public boolean isRegisterNaRxBus() {
        return false;
    }
}
