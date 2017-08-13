package com.eryuzhisen.android.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.eryuzhisen.android.R;
import com.eryuzhisen.android.adapter.EyzsRecyclerViewAdpater;
import com.eryuzhisen.android.widget.EyzsTitleView;
import com.na.mvp.base.NaBaseFragment;


public class CollectFragment extends NaBaseFragment {
    private EyzsTitleView etvTitle;
    private RecyclerView rlListView;
    private EyzsRecyclerViewAdpater mAdapter;

    public static CollectFragment newInstance() {
        CollectFragment fragment = new CollectFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_collect;
    }

    @Override
    protected void onListener() {
        super.onListener();
    }

    @Override
    protected void onInit() {
        super.onInit();
        etvTitle = (EyzsTitleView) getRootView().findViewById(R.id.etvTitle);
        rlListView = (RecyclerView) getRootView().findViewById(R.id.rlListView);
        etvTitle.setTitleResId(R.string.collect);
        mAdapter = new EyzsRecyclerViewAdpater();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        rlListView.setLayoutManager(layoutManager);
        rlListView.setAdapter(mAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        if(presenter != null) {
//            presenter.updateData();
//        }
//    }

//    @Override
//    public void onUpdate() {
//        if(presenter != null) {
//            mAdapter.setData(presenter.getData());
//            mAdapter.notifyDataSetChanged();
//        }
//    }
}
