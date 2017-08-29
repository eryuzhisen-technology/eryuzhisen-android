package com.eryuzhisen.android.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.eryuzhisen.android.R;
import com.eryuzhisen.android.adapter.EyzsRecyclerViewAdpater;
import com.eryuzhisen.android.contract.ResetPasswordContract;
import com.eryuzhisen.android.decoration.LoginItemDecoration;
import com.eryuzhisen.android.presenter.ResetPasswordPresenter;
import com.eryuzhisen.android.utils.DensityUtils;
import com.eryuzhisen.android.widget.EyzsSubTitleView;
import com.na.mvp.base.NaBaseActivity;

public class ResetPasswordActivity extends NaBaseActivity<ResetPasswordPresenter> implements  ResetPasswordContract.View{

    private EyzsSubTitleView estTitle;
    private RecyclerView rlListView;
    private EyzsRecyclerViewAdpater mAdapter;

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
        rlListView = (RecyclerView) findViewById(R.id.rlListView);
        estTitle.setTitleResId(R.string.get_password);
        estTitle.setLeftButtonImageResource(R.mipmap.icon_back, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mAdapter = new EyzsRecyclerViewAdpater();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rlListView.setLayoutManager(layoutManager);
        rlListView.addItemDecoration(new LoginItemDecoration(DensityUtils.dip2px(this, 15)));
        rlListView.setAdapter(mAdapter);
    }


    @Override
    protected void onListener() {
        super.onListener();
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
            mAdapter.setData(presenter.getData());
            mAdapter.notifyDataSetChanged();
        }
    }
}
