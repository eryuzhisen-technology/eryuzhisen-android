package com.eryuzhisen.android.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eryuzhisen.android.R;

import org.w3c.dom.Text;

/**
 * @actor:taotao
 * @DATE: 2017/8/5
 */

public class EyzsTitleView extends RelativeLayout {

    private TextView tvTitle;
    private ImageView ivLogo;
    private ImageView ivButton1;
    private ImageView ivButton2;


    public EyzsTitleView(Context context) {
        super(context);
        setlayout(context);
    }

    public EyzsTitleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setlayout(context);
    }

    public EyzsTitleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setlayout(context);
    }

    public EyzsTitleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setlayout(context);
    }


    public void setlayout(Context context) {
        View.inflate(context, R.layout.view_title, this);
        tvTitle = (TextView) this.findViewById(R.id.tvTitle);
        ivLogo = (ImageView) this.findViewById(R.id.ivLogo);
        ivButton1 = (ImageView) this.findViewById(R.id.ivButton1);
        ivButton2 = (ImageView) this.findViewById(R.id.ivButton2);
        ivButton1.setVisibility(GONE);
        ivButton2.setVisibility(GONE);
        ivLogo.setImageResource(R.mipmap.icon_brand);
    }

    public void setTitleResId(int resId) {
        tvTitle.setText(resId);
    }

    public void setTitleText(String text) {
        if (!TextUtils.isEmpty(text)) {
            tvTitle.setText(text);
        }
    }

    public TextView getTvTitle() {
        return tvTitle;
    }

    public ImageView getLogo() {
        return ivLogo;
    }

    public ImageView getButton2() {
        return ivButton2;
    }

    public ImageView getButton1() {
        return ivButton1;
    }

    public void setButton1ImageResource(int resId, OnClickListener listener) {
        this.ivButton1.setImageResource(resId);
        this.ivButton1.setOnClickListener(listener);
        this.ivButton1.setVisibility(VISIBLE);
    }

    public void setButton2ImageResource(int resId, OnClickListener listener) {
        this.ivButton2.setImageResource(resId);
        this.ivButton2.setOnClickListener(listener);
        this.ivButton2.setVisibility(VISIBLE);
    }

}
