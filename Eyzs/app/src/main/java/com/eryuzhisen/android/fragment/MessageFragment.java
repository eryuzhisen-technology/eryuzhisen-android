package com.eryuzhisen.android.fragment;


import com.eryuzhisen.android.R;
import com.na.mvp.base.NaBaseFragment;

public class MessageFragment extends NaBaseFragment {

    public static MessageFragment newInstance() {
        MessageFragment fragment = new MessageFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_message;
    }
}
