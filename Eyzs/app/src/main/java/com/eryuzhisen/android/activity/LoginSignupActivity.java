package com.eryuzhisen.android.activity;

import android.view.View;

import com.eryuzhisen.android.R;
import com.na.mvp.base.NaBaseActivity;

public class LoginSignupActivity extends NaBaseActivity implements View.OnClickListener {
    @Override
    protected int getContentId() {
        return R.layout.activity_login_signup;
    }

    @Override
    protected String getActiviyName() {
        return ActivityManager.login_signup;
    }

    @Override
    protected void onInit() {
        super.onInit();
    }

    @Override
    protected void onListener() {
        super.onListener();
        findViewById(R.id.btLogin).setOnClickListener(this);
        findViewById(R.id.btRegister).setOnClickListener(this);
        findViewById(R.id.ivClose).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivClose:{
                finish();
                break;
            }
            case R.id.btLogin:
                ActivityManager.getInstance().jumpToActivity(this, ActivityManager.login);
                break;
            case R.id.btRegister:
                ActivityManager.getInstance().jumpToActivity(this, ActivityManager.register);
                break;
        }
    }
}
