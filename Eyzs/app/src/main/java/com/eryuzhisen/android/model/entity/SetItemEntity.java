package com.eryuzhisen.android.model.entity;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eryuzhisen.android.R;

/**
 * @actor:taotao
 * @DATE: 2017/8/12
 */

public class SetItemEntity extends BaseEntity {
    public final static int TypeNum = 1;
    public final static int TypeArrow = 2;
    private int iconResId;
    private String title;
    private int titleResId;
    private int msgNum;
    private int bgResId;
    private int type;
    private boolean isShowline;

    public SetItemEntity() {

    }


    public int getIconResId() {
        return iconResId;
    }

    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMsgNum() {
        return msgNum;
    }

    public void setMsgNum(int msgNum) {
        this.msgNum = msgNum;
    }

    public int getBgResId() {
        return bgResId;
    }

    public void setBgResId(int bgResId) {
        this.bgResId = bgResId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getTitleResId() {
        return titleResId;
    }

    public void setTitleResId(int titleResId) {
        this.titleResId = titleResId;
    }

    public boolean isShowline() {
        return isShowline;
    }

    public void setShowline(boolean showline) {
        isShowline = showline;
    }

    @Override
    public int getEntityType() {
        return EntityType_SetItem;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder) {
        ViewHolder vh = (ViewHolder) holder;
        vh.rootView.setBackgroundResource(bgResId);
        vh.ivIcon.setImageResource(iconResId);
        if(!TextUtils.isEmpty(title)){
            vh.tvTitle.setText(title);
        } else {
            vh.tvTitle.setText(titleResId);
        }

        if(type == TypeNum){
            vh.ivArrow.setVisibility(View.GONE);
            vh.tvNum.setVisibility(View.VISIBLE);
            vh.tvNum.setText("" + msgNum);
        } else {
            vh.ivArrow.setVisibility(View.VISIBLE);
            vh.tvNum.setVisibility(View.GONE);
        }

        if(isShowline){
            vh.vLine.setVisibility(View.VISIBLE);
        } else {
            vh.vLine.setVisibility(View.GONE);
        }
    }


    public static RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setting, parent, false);
        return new ViewHolder(view);
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        private View rootView;
        private ImageView ivIcon;
        private TextView tvTitle;
        private View vLine;
        private ImageView ivArrow;
        private TextView tvNum;

        public ViewHolder(View view) {
            super(view);
            rootView = view;
            ivIcon = (ImageView) view.findViewById(R.id.ivIcon);
            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            vLine = (View) view.findViewById(R.id.vLine);
            ivArrow = (ImageView) view.findViewById(R.id.ivArrow);
            tvNum = (TextView) view.findViewById(R.id.tvNum);
        }
    }
}
