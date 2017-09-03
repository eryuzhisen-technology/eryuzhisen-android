package com.eryuzhisen.android.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.eryuzhisen.android.R;
import com.eryuzhisen.android.contract.LoginContract;
import com.eryuzhisen.android.presenter.LoginPresenter;
import com.eryuzhisen.android.utils.ToastUtil;
import com.eryuzhisen.android.widget.EyzsSubTitleView;
import com.na.mvp.base.NaBaseActivity;

public class LoginActivity extends NaBaseActivity<LoginPresenter> implements LoginContract.View, View.OnClickListener {

    private EyzsSubTitleView estTitle;
    //    private RecyclerView rlListView;
//    private EyzsRecyclerViewAdpater mAdapter;
    private TextView tvRegister;
    private TextView tvForgot;
    private ImageView ivWechat;
    private ImageView ivQq;
    private ImageView ivWeibo;


    private EditText getEtPhone() {
        return (EditText) findViewById(R.id.etPhone);
    }

    private EditText getEtPassword() {
        return (EditText) findViewById(R.id.etPassword);
    }

    @Override
    protected int getContentId() {
        return R.layout.activity_login;
    }

    @Override
    protected String getActiviyName() {
        return ActivityManager.login;
    }

    @Override
    protected void onInit() {
        super.onInit();
        estTitle = (EyzsSubTitleView) findViewById(R.id.estTitle);
        tvRegister = (TextView) findViewById(R.id.tvRegister);
        tvForgot = (TextView) findViewById(R.id.tvForgot);
        ivWechat = (ImageView) findViewById(R.id.ivWechat);
        ivQq = (ImageView) findViewById(R.id.ivQq);
        ivWeibo = (ImageView) findViewById(R.id.ivWeibo);
        estTitle.setTitleText("");
    }


    @Override
    protected void onListener() {
        super.onListener();
        findViewById(R.id.tvButton).setOnClickListener(this);
        tvRegister.setOnClickListener(this);
        tvForgot.setOnClickListener(this);
        ivWechat.setOnClickListener(this);
        ivQq.setOnClickListener(this);
        ivWeibo.setOnClickListener(this);
        estTitle.setLeftButtonImageResource(R.mipmap.icon_close, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvButton: {
                if(this.presenter != null){
                    String phone = null;
                    if(getEtPhone() != null){
                        phone = getEtPhone().getText().toString();
                    }
                    String pwd = null;
                    if (getEtPassword() != null){
                        pwd = getEtPassword().getText().toString();
                    }
                    this.presenter.login(phone, pwd);
                }
                break;
            }
            case R.id.tvRegister:{
                ActivityManager.getInstance().jumpToActivity(this, ActivityManager.register);
                break;
            }
            case R.id.tvForgot:{
                ActivityManager.getInstance().jumpToActivity(this, ActivityManager.reset_password);
                break;
            }
            case R.id.ivWechat:{
                break;
            }
            case R.id.ivQq:{
                break;
            }
            case R.id.ivWeibo:{
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
            presenter.updateData();
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
    public void onLogin(boolean isSuc) {
        if (isSuc) {
            ToastUtil.showTextShort("登录成功");
            ActivityManager.getInstance().jumpToActivity(this, ActivityManager.main);
            finish();
        } else {
            ToastUtil.showTextShort("登录失败");
        }
    }

}
