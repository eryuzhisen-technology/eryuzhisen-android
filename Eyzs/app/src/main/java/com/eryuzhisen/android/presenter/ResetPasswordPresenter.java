package com.eryuzhisen.android.presenter;

import com.eryuzhisen.android.contract.ResetPasswordContract;
import com.eryuzhisen.android.model.ResetPasswordModel;
import com.na.mvp.presenters.NaBasePresenter;

import java.util.List;

/**
 * @actor:taotao
 * @DATE: 2017/8/27
 */

public class ResetPasswordPresenter extends NaBasePresenter<ResetPasswordContract.View, ResetPasswordModel> implements ResetPasswordContract.Presenter {

    @Override
    public List getData() {
        return model.getData();
    }

    @Override
    public void updateData() {
        this.view.onUpdate();
    }
}
