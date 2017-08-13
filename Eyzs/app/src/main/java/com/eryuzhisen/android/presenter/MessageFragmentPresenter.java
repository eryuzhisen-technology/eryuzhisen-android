package com.eryuzhisen.android.presenter;

import com.eryuzhisen.android.contract.MessageFragmentContract;
import com.eryuzhisen.android.model.MessageFragmentModel;
import com.na.mvp.presenters.NaBasePresenter;

import java.util.List;

/**
 * @actor:taotao
 * @DATE: 2017/8/12
 */

public class MessageFragmentPresenter extends NaBasePresenter<MessageFragmentContract.View, MessageFragmentModel> implements MessageFragmentContract.Presenter{

    @Override
    public List getData() {
        return model.getData();
    }

    @Override
    public void updateData() {
        view.onUpdate();
    }
}
