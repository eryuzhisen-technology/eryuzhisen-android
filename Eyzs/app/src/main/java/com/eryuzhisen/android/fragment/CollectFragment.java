package com.eryuzhisen.android.fragment;

import com.eryuzhisen.android.R;
import com.na.mvp.base.NaBaseFragment;


public class CollectFragment extends NaBaseFragment {

    public static CollectFragment newInstance() {
        CollectFragment fragment = new CollectFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_collect;
    }

}
