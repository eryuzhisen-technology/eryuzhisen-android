package com.eryuzhisen.android.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.eryuzhisen.android.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @actor:taotao
 * @DATE: 2017/7/29
 */

public class WecomeAdapter extends PagerAdapter {

    private List<WecomeItem> mData;

    public WecomeAdapter() {
        if (mData == null) {
            mData = new ArrayList<WecomeItem>();
            WecomeItem item = new WecomeItem(R.mipmap.welcome_title1, R.mipmap.welcome_img1);
            mData.add(item);
            item = new WecomeItem(R.mipmap.welcome_title2, R.mipmap.welcome_img2);
            mData.add(item);
            item = new WecomeItem(R.mipmap.welcome_title3, R.mipmap.welcome_img3);
            mData.add(item);
            item = new WecomeItem(R.mipmap.welcome_title4, R.mipmap.welcome_img4);
            mData.add(item);
        }
    }

    @Override
    public int getCount() {
        int size = 0;
        if (mData != null) {
            size = mData.size();
        }
        return size;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup parent, int position) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_welcome, parent, false);
        ImageView ivImg = view.findViewById(R.id.ivImg);
        ImageView ivTitle = view.findViewById(R.id.ivTitle);
        WecomeItem item = mData.get(position);
        ivImg.setImageResource(item.imgResId);
        ivTitle.setImageResource(item.titleResId);
        parent.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View) object);
    }

    private class WecomeItem {
        public int titleResId;
        public int imgResId;

        public WecomeItem(int titleResId, int imgResId) {
            this.titleResId = titleResId;
            this.imgResId = imgResId;
        }
    }

}
