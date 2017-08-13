package com.eryuzhisen.android.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.eryuzhisen.android.model.entity.BaseEntity;

import java.util.List;

/**
 * @actor:taotao
 * @DATE: 2017/8/12
 */

public class EyzsRecyclerViewAdpater extends RecyclerView.Adapter {
    private List<BaseEntity> mData;

    public List<BaseEntity> getData() {
        return mData;
    }

    public void setData(List<BaseEntity> mData) {
        this.mData = mData;
    }

    public EyzsRecyclerViewAdpater() {

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return BaseEntity.createViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        getItem(position).onBindViewHolder(holder);
    }

    private BaseEntity getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getItemCount() {
        int count = 0;
        if(mData != null){
            count = mData.size();
        }
        return count;
    }

    @Override
    public int getItemViewType(int position) {
        BaseEntity entity = mData.get(position);
        return entity.getEntityType();
    }
}
