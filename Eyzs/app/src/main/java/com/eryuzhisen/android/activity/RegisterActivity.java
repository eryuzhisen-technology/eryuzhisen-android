package com.eryuzhisen.android.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eryuzhisen.android.R;
import com.eryuzhisen.android.contract.RegisterContract;
import com.eryuzhisen.android.presenter.RegisterPresenter;
import com.eryuzhisen.android.widget.EyzsSubTitleView;
import com.na.mvp.base.NaBaseActivity;
import com.na.mvp.glide.NaGlide;

public class RegisterActivity extends NaBaseActivity<RegisterPresenter> implements RegisterContract.View, View.OnClickListener {
    private EyzsSubTitleView estTitle;
    private TextView tvSubTitle;
    private RelativeLayout rlPicture;
    private ImageView ivVcodeImg;
    private TextView tvMsgcode;
    private TextView tvUserAgree;
    private TextView tvPrivacyPolicy;


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

    @Override
    protected int getContentId() {
        return R.layout.activity_register;
    }

    @Override
    protected String getActiviyName() {
        return ActivityManager.register;
    }

    @Override
    protected void onInit() {
        super.onInit();
        estTitle = (EyzsSubTitleView) findViewById(R.id.estTitle);
        tvSubTitle = (TextView) findViewById(R.id.tvSubTitle);
        rlPicture = (RelativeLayout) findViewById(R.id.rlPicture);
        ivVcodeImg = (ImageView) findViewById(R.id.ivVcodeImg);
        tvMsgcode = (TextView) findViewById(R.id.tvMsgcode);
        tvUserAgree = (TextView) findViewById(R.id.tvUserAgree);
        tvPrivacyPolicy = (TextView) findViewById(R.id.tvPrivacyPolicy);
        estTitle.setTitleText("");
    }


    @Override
    protected void onListener() {
        super.onListener();
        findViewById(R.id.tvButton).setOnClickListener(this);
        tvSubTitle.setOnClickListener(this);
        ivVcodeImg.setOnClickListener(this);
        tvMsgcode.setOnClickListener(this);
        tvSubTitle.setOnClickListener(this);
        tvUserAgree.setOnClickListener(this);
        tvPrivacyPolicy.setOnClickListener(this);
        getEtMsgVcode().setOnClickListener(this);
        estTitle.setLeftButtonImageResource(R.mipmap.icon_close, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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
                    presenter.register(phone, pwd, msgcode);
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
            case R.id.tvUserAgree: {
                break;
            }
            case R.id.tvPrivacyPolicy: {
                break;
            }
            default: {
                break;
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (presenter != null) {
//            presenter.updateData();
        }
    }


    @Override
    public void onUpdate() {
        if (presenter != null) {
//            mAdapter.setData(presenter.getData());
//            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onPicVcode(byte[] img) {
        if(img != null) {
            NaGlide.with(this).load(img).into(ivVcodeImg);
        }
    }

}
