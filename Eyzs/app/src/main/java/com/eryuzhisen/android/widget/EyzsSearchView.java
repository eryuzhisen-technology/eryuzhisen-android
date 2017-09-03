package com.eryuzhisen.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.eryuzhisen.android.R;

/**
 * @actor:taotao
 * @DATE: 2017/9/3
 */

public class EyzsSearchView extends RelativeLayout {
    public EyzsSearchView(Context context) {
        super(context);
        setlayout(context);
    }

    public EyzsSearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setlayout(context);
    }

    public EyzsSearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setlayout(context);
    }

    public EyzsSearchView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setlayout(context);
    }

    private void setlayout(Context context) {
        View.inflate(context, R.layout.view_search, this);
    }
}
