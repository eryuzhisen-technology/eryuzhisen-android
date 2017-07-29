package com.eryuzhisen.android.activity;


import com.eryuzhisen.android.R;
import com.eryuzhisen.android.contract.LauncherContract;
import com.eryuzhisen.android.presenter.LauncherPresenter;
import com.eryuzhisen.android.utils.SharePrefenceUtil;
import com.na.mvp.base.NaBaseActivity;

public class LauncherActivity extends NaBaseActivity<LauncherPresenter> implements LauncherContract.View{

    @Override
    protected int getContentId() {
        return R.layout.activity_launcher;
    }

    @Override
    protected String getActiviyName() {
        return ActivityManager.launcher;
    }

    @Override
    protected void onInit() {
        super.onInit();
        presenter.startLauncher(this);
    }

    @Override
    public void onLauncherFinish() {
        if(SharePrefenceUtil.isWecomeOption()){
            ActivityManager.getInstance().jumpToActivity(this, ActivityManager.wecome);
        } else {
            ActivityManager.getInstance().jumpToActivity(this, ActivityManager.main);
        }
        finish();
    }
}
