package com.eryuzhisen.android.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by joy on 16/10/19.
 */
public class MyPageIndicator extends LinearLayout {
    public MyPageIndicator(Context context) {
        super(context);
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER);
    }

    private Drawable selectDrawable;
    private Drawable normalDrawable;
    private int position = 0;

    public MyPageIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(HORIZONTAL);
    }

    public MyPageIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(HORIZONTAL);
    }

    public void setCount(int count) {
        views.clear();
        removeAllViews();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(dip2px(getContext(), 8f), dip2px(getContext(), 8f));
        params.leftMargin = dip2px(getContext(), 5);
        params.rightMargin = dip2px(getContext(), 5);
        for (int i = 0; i < count; i++) {
            View view = new View(getContext());
            view.setBackgroundDrawable(normalDrawable);
            view.setLayoutParams(params);
            addView(view);
            views.add(view);
        }
        setSelection(position);
    }

    public void setSelection(int position) {
        if (position >= views.size()) {
            return;
        }
        this.position = position;
        changeStatus();
    }

    private ArrayList<View> views = new ArrayList<>();
    ;

    private void changeStatus() {
        for (int i = 0; i < views.size(); i++) {
            if (position == i) {
                views.get(i).setBackgroundDrawable(selectDrawable);
            } else {
                views.get(i).setBackgroundDrawable(normalDrawable);
            }
        }
    }

    public void setSelectedDrawable(int res) {
        selectDrawable = getResources().getDrawable(res);
    }

    public void setNormalDrawable(int res) {
        normalDrawable = getResources().getDrawable(res);
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
