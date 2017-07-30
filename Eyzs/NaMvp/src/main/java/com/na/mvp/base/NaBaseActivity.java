package com.na.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.na.mvp.presenters.NaBasePresenter;
import com.na.mvp.utils.GenericHelper;

/**
 * @actor:taotao
 * @DATE: 2017/7/29
 */

public abstract class NaBaseActivity<T extends NaBasePresenter> extends AppCompatActivity {
    protected T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeSetContentView();
        setContentView(getContentId());
        getSupportActionBar().hide();
        try {
            presenter = GenericHelper.newPresenter(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        onInit();
        onListener();
        if (presenter != null) {
            presenter.start();
        }
    }

    /**
     * 需要在SetContentView之前做的操作
     */
    protected void beforeSetContentView() {

    }


    /**
     * 在这里面进行初始化
     */
    protected void onInit() {

    }

    /**
     * 这里面写监听事件
     */
    protected void onListener() {

    }

    /**
     * 获取布局的id
     *
     * @return
     */
    protected abstract int getContentId();

    protected abstract String getActiviyName();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.destroy();
        }
    }
}