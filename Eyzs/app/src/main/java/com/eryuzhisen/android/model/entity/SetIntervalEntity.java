package com.eryuzhisen.android.model.entity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eryuzhisen.android.R;

/**
 * @actor:taotao
 * @DATE: 2017/8/13
 */

public class SetIntervalEntity extends BaseEntity {
    @Override
    public int getEntityType() {
        return EntityType_SetInterval;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder) {

    }

    public static RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setinterval, parent, false);
        return new ViewHolder(view);
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View view) {
            super(view);
        }
    }
}
