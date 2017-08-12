package com.eryuzhisen.android.fragment;


import android.support.v4.app.Fragment;

import com.eryuzhisen.android.R;
import com.na.mvp.base.NaBaseFragment;


public class MyselfFragment extends NaBaseFragment {

    public static MyselfFragment newInstance() {
        MyselfFragment fragment = new MyselfFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_myself;
    }

}
