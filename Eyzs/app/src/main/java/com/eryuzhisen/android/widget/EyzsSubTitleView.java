package com.eryuzhisen.android.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eryuzhisen.android.R;

/**
 * @actor:taotao
 * @DATE: 2017/8/27
 */

public class EyzsSubTitleView extends RelativeLayout {

    private TextView tvTitle;
    private ImageView ivLeftButton;

    public EyzsSubTitleView(Context context) {
        super(context);
        setlayout(context);
    }

    public EyzsSubTitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setlayout(context);
    }

    public EyzsSubTitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setlayout(context);
    }

    public EyzsSubTitleView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setlayout(context);
    }

    private void setlayout(Context context) {
        View.inflate(context, R.layout.view_sub_title, this);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        ivLeftButton = (ImageView) findViewById(R.id.ivLeftButton);
    }

    public void setTitleText(String text) {
        if (!TextUtils.isEmpty(text)) {
            tvTitle.setText(text);
        }
    }

    public void setTitleResId(int resId) {
        tvTitle.setText(resId);
    }

    public void setLeftButtonImageResource(int resId, OnClickListener listener) {
        this.ivLeftButton.setImageResource(resId);
        this.ivLeftButton.setOnClickListener(listener);
        this.ivLeftButton.setVisibility(VISIBLE);
    }

}
