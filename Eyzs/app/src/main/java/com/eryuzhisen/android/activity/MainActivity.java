package com.eryuzhisen.android.activity;

import android.os.Bundle;

import com.eryuzhisen.android.R;
import com.eryuzhisen.android.contract.MainContract;
import com.eryuzhisen.android.presenter.MainPresenter;
import com.na.mvp.base.NaBaseActivity;

public class MainActivity extends NaBaseActivity<MainPresenter> implements MainContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentId() {
        return R.layout.activity_main;
    }

    @Override
    protected String getActiviyName() {
        return ActivityManager.main;
    }
}
