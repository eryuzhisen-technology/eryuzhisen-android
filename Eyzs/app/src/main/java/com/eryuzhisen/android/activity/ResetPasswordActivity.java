package com.eryuzhisen.android.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.eryuzhisen.android.R;
import com.eryuzhisen.android.contract.ResetPasswordContract;
import com.eryuzhisen.android.presenter.ResetPasswordPresenter;
import com.eryuzhisen.android.widget.EyzsSubTitleView;
import com.na.mvp.base.NaBaseActivity;

public class ResetPasswordActivity extends NaBaseActivity<ResetPasswordPresenter> implements ResetPasswordContract.View, View.OnClickListener {


    private EyzsSubTitleView estTitle;
    private TextView tvSubTitle;
    private TextView tvMsgcode;


    private EditText getEtPhone() {
        return (EditText) findViewById(R.id.etPhone);
    }

    private EditText getEtMsgVcode() {
        return (EditText) findViewById(R.id.etMsgVcode);
    }

    private EditText getEtPassword() {
        return (EditText) findViewById(R.id.etPassword);
    }

    private EditText getEtConfirmPassword() {
        return (EditText) findViewById(R.id.etConfirmPassword);
    }

    @Override
    protected int getContentId() {
        return R.layout.activity_reset_password;
    }

    @Override
    protected String getActiviyName() {
        return ActivityManager.reset_password;
    }

    @Override
    protected void onInit() {
        super.onInit();
        estTitle = (EyzsSubTitleView) findViewById(R.id.estTitle);

        tvSubTitle = (TextView) findViewById(R.id.tvSubTitle);
        tvMsgcode = (TextView) findViewById(R.id.tvMsgcode);
        findViewById(R.id.tvButton).setOnClickListener(this);
    }


    @Override
    protected void onListener() {
        super.onListener();
        estTitle.setLeftButtonImageResource(R.mipmap.icon_close, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tvSubTitle.setOnClickListener(this);
        tvMsgcode.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvButton: {
                break;
            }
            case R.id.tvSubTitle: {
                finish();
                break;
            }
            case R.id.tvMsgcode: {
                break;
            }
            default: {
                break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (presenter != null) {

        }
    }


    @Override
    public void onUpdate() {
        if (presenter != null) {

        }
    }
}
