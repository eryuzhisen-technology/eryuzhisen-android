package com.eryuzhisen.android.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eryuzhisen.android.R;
import com.eryuzhisen.android.contract.ResetPasswordContract;
import com.eryuzhisen.android.presenter.ResetPasswordPresenter;
import com.eryuzhisen.android.utils.ToastUtil;
import com.eryuzhisen.android.widget.EyzsSubTitleView;
import com.na.mvp.base.NaBaseActivity;
import com.na.mvp.glide.NaGlide;

public class ResetPasswordActivity extends NaBaseActivity<ResetPasswordPresenter> implements ResetPasswordContract.View, View.OnClickListener {


    private EyzsSubTitleView estTitle;
    private TextView tvSubTitle;
    private TextView tvMsgcode;
    private RelativeLayout rlPicture;
    private ImageView ivVcodeImg;


    private EditText getEtPhone() {
        return (EditText) findViewById(R.id.etPhone);
    }

    private EditText getEtPicVcode() {
        return (EditText) findViewById(R.id.etPicVcode);
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
        rlPicture = (RelativeLayout) findViewById(R.id.rlPicture);
        ivVcodeImg = (ImageView) findViewById(R.id.ivVcodeImg);
        tvMsgcode = (TextView) findViewById(R.id.tvMsgcode);
        findViewById(R.id.tvButton).setOnClickListener(this);
        estTitle.setTitleText("");
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
        ivVcodeImg.setOnClickListener(this);
        tvMsgcode.setOnClickListener(this);
        getEtMsgVcode().setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvButton: {
                String phone = null;
                if(getEtPhone() != null){
                    phone = getEtPhone().getText().toString();
                }
                String pwd = null;
                if(getEtPassword() != null){
                    pwd = getEtPassword().getText().toString();
                }
                String msgcode = null;
                if(getEtMsgVcode() != null){
                    msgcode = getEtMsgVcode().getText().toString();
                }
                if(presenter != null){
                    presenter.resetPassword(phone, pwd, msgcode);
                }
                break;
            }
            case R.id.tvSubTitle: {
                finish();
                break;
            }
            case R.id.etMsgVcode:
            case R.id.ivVcodeImg: {
                rlPicture.setVisibility(View.VISIBLE);
                if(presenter != null){
                    presenter.getPicCode();
                }
                break;
            }
            case R.id.tvMsgcode: {

                if(rlPicture.getVisibility() == View.GONE){
                    rlPicture.setVisibility(View.VISIBLE);
                    if(presenter != null){
                        presenter.getPicCode();
                    }
                    return;
                }
                String phone = null;
                if(getEtPhone() != null){
                    phone = getEtPhone().getText().toString();
                }
                String pcode = null;
                if(getEtPicVcode() != null){
                    pcode = getEtPicVcode().getText().toString();
                }
                if(presenter != null){
                    presenter.getMsgCode(phone, pcode);
                }
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

    @Override
    public void onPicVcode(byte[] img) {
        if(img != null) {
            NaGlide.with(this).load(img).into(ivVcodeImg);
        } else {
            ToastUtil.showTextShort("PicVcode failed");
        }
    }

    @Override
    public void onMsgVcode(boolean isSuccess) {
        if (isSuccess) {
            ToastUtil.showTextShort("msg code ok");
        } else {
            ToastUtil.showTextShort("msg code failed");
        }
    }

    @Override
    public void onResetPwd(boolean isSuccess) {
        if (isSuccess) {
            ToastUtil.showTextShort("ResetPwd ok");
            ActivityManager.getInstance().jumpToActivity(this, ActivityManager.main);
            finish();
        } else {
            ToastUtil.showTextShort("ResetPwd failed");
        }
    }


}
