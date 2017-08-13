package com.eryuzhisen.android.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.eryuzhisen.android.R;
import com.eryuzhisen.android.adapter.EyzsRecyclerViewAdpater;
import com.eryuzhisen.android.contract.MyselfFragmentContract;
import com.eryuzhisen.android.presenter.MyselfFragmentPresenter;
import com.eryuzhisen.android.widget.EyzsTitleView;
import com.na.mvp.base.NaBaseFragment;


public class MyselfFragment extends NaBaseFragment<MyselfFragmentPresenter> implements MyselfFragmentContract.View, View.OnClickListener{
    private EyzsTitleView etvTitle;
    private RecyclerView rlListView;
    private EyzsRecyclerViewAdpater mAdapter;
    public static MyselfFragment newInstance() {
        MyselfFragment fragment = new MyselfFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_myself;
    }

    @Override
    protected void onInit() {
        super.onInit();
        etvTitle = (EyzsTitleView) getRootView().findViewById(R.id.etvTitle);
        rlListView = (RecyclerView) getRootView().findViewById(R.id.rlListView);
        etvTitle.setTitleResId(R.string.myself);
        mAdapter = new EyzsRecyclerViewAdpater();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        rlListView.setLayoutManager(layoutManager);
        rlListView.setAdapter(mAdapter);
    }

    @Override
    protected void onListener() {
        super.onListener();
        etvTitle.setButton1ImageResource(R.mipmap.title_icon_share, this);
        etvTitle.setButton2ImageResource(R.mipmap.title_icon_setting, this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onResume() {
        super.onResume();
        if(presenter != null) {
            presenter.updateData();
        }
    }

    @Override
    public void onUpdate() {
        if(presenter != null) {
            mAdapter.setData(presenter.getData());
            mAdapter.notifyDataSetChanged();
        }
    }
}
