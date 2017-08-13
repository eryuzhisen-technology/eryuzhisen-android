package com.eryuzhisen.android.presenter;

import com.eryuzhisen.android.contract.MyselfFragmentContract;
import com.eryuzhisen.android.model.MyselfFragmentModel;
import com.na.mvp.presenters.NaBasePresenter;

import java.util.List;

/**
 * @actor:taotao
 * @DATE: 2017/8/13
 */

public class MyselfFragmentPresenter extends NaBasePresenter<MyselfFragmentContract.View, MyselfFragmentModel> implements MyselfFragmentContract.Presenter {

    @Override
    public List getData() {
        return model.getData();
    }

    @Override
    public void updateData() {
        view.onUpdate();
    }
}
