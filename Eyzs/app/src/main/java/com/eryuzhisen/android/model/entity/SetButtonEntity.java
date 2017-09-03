package com.eryuzhisen.android.model.entity;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eryuzhisen.android.R;

/**
 * @actor:taotao
 * @DATE: 2017/8/13
 */

public class SetButtonEntity extends BaseEntity {
    private OnClickItemListener listener;
    private String title;
    private int titleResId;
    private int bgResId;

    public void setBgResId(int bgResId) {
        this.bgResId = bgResId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTitleResId(int titleResId) {
        this.titleResId = titleResId;
    }

    @Override
    public int getEntityType() {
        return EntityType_SetButton;
    }


    public void setListener(OnClickItemListener listener) {
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder) {
        ViewHolder vh = (ViewHolder) holder;
        vh.rootView.setBackgroundResource(bgResId);
        if(!TextUtils.isEmpty(title)){
            vh.tvTitle.setText(title);
        } else {
            vh.tvTitle.setText(titleResId);
        }

        vh.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null){
                    listener.onClick(view);
                }
            }
        });
    }

    public static RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setbutton, parent, false);
        return new ViewHolder(view);
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        private View rootView;
        private TextView tvTitle;

        public ViewHolder(View view) {
            super(view);
            rootView = view;
            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        }
    }

    public interface OnClickItemListener{
        void onClick(View view);
    }
}
