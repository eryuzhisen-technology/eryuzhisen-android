package com.eryuzhisen.android.fragment;


import com.eryuzhisen.android.R;
import com.na.mvp.base.NaBaseFragment;

public class FindFragment extends NaBaseFragment {

    public static FindFragment newInstance() {
        FindFragment fragment = new FindFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_find;
    }
}
