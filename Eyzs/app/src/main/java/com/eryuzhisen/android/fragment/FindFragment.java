package com.eryuzhisen.android.fragment;


import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.eryuzhisen.android.R;
import com.eryuzhisen.android.contract.FindFragmentContract;
import com.eryuzhisen.android.presenter.FindFragmentPresenter;
import com.eryuzhisen.android.widget.EyzsBannerView;
import com.eryuzhisen.android.widget.EyzsSearchView;
import com.eryuzhisen.android.widget.EyzsTitleView;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.na.mvp.base.NaBaseFragment;

public class FindFragment extends NaBaseFragment<FindFragmentPresenter> implements FindFragmentContract.View, View.OnClickListener {
    private TwinklingRefreshLayout trLayout;
    private EyzsTitleView etvTitle;
    private EyzsSearchView esView;
    private EyzsBannerView ebView;
    private RecyclerView rlListView;

    public static FindFragment newInstance() {
        FindFragment fragment = new FindFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_find;
    }

    @Override
    protected void onListener() {
        super.onListener();
        etvTitle.setButton1ImageResource(R.mipmap.title_icon_filter, this);
    }

    @Override
    protected void onInit() {
        super.onInit();
        View view = getRootView();
        trLayout = (TwinklingRefreshLayout) view.findViewById(R.id.trLayout);
        etvTitle = (EyzsTitleView) view.findViewById(R.id.etvTitle);
        esView = (EyzsSearchView) view.findViewById(R.id.esView);
        ebView = (EyzsBannerView) view.findViewById(R.id.ebView);
        rlListView = (RecyclerView) view.findViewById(R.id.rlListView);
        etvTitle.setTitleResId(R.string.story);
    }

    @Override
    public void onClick(View view) {

    }
}
