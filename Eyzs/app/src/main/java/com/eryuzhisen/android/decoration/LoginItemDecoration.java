package com.eryuzhisen.android.decoration;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @actor:taotao
 * @DATE: 2017/8/27
 */

public class LoginItemDecoration extends RecyclerView.ItemDecoration {
    int mSpace;

    public LoginItemDecoration(int mSpace) {
        this.mSpace = mSpace;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = mSpace;
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.top = mSpace;
        }
    }
}
