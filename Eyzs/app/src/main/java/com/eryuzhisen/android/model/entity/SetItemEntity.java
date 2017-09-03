package com.eryuzhisen.android.model.entity;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eryuzhisen.android.R;
import com.eryuzhisen.android.utils.StringUtils;

/**
 * @actor:taotao
 * @DATE: 2017/8/12
 */

public class SetItemEntity extends BaseEntity {
    public final static int TypeNum = 1;
    public final static int TypeArrow = 2;
    public final static int TypeSubTitle = 3;
    private int iconResId;
    private String title;
    private int titleResId;
    private int msgNum;
    private int bgResId;
    private int type;
    private boolean isShowline;

    private String subTitle;
    private int subTitleResId;

    private OnClickItemListener listener;

    public SetItemEntity() {

    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public void setSubTitleResId(int subTitleResId) {
        this.subTitleResId = subTitleResId;
    }

    public void setListener(OnClickItemListener listener) {
        this.listener = listener;
    }

    public int getIconResId() {
        return iconResId;
    }

    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setMsgNum(int msgNum) {
        this.msgNum = msgNum;
    }


    public void setBgResId(int bgResId) {
        this.bgResId = bgResId;
    }


    public void setType(int type) {
        this.type = type;
    }


    public void setTitleResId(int titleResId) {
        this.titleResId = titleResId;
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
        if (!TextUtils.isEmpty(title)) {
            vh.tvTitle.setText(title);
        } else {
            vh.tvTitle.setText(titleResId);
        }

        if (type == TypeNum) {
            vh.ivArrow.setVisibility(View.GONE);
            vh.tvSubTitle.setVisibility(View.GONE);
            vh.tvNum.setVisibility(View.VISIBLE);
            vh.tvNum.setText("" + msgNum);
        } else if (type == TypeSubTitle) {
            vh.ivArrow.setVisibility(View.GONE);
            vh.tvNum.setVisibility(View.GONE);
            vh.tvSubTitle.setVisibility(View.VISIBLE);
            if(!StringUtils.isEmpty(subTitle)){
                vh.tvSubTitle.setText(subTitle);
            } else {
                vh.tvSubTitle.setText(subTitleResId);
            }

        } else {
            vh.ivArrow.setVisibility(View.VISIBLE);
            vh.tvNum.setVisibility(View.GONE);
            vh.tvSubTitle.setVisibility(View.GONE);
        }

        if (isShowline) {
            vh.vLine.setVisibility(View.VISIBLE);
        } else {
            vh.vLine.setVisibility(View.GONE);
        }

        vh.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null) {
                    listener.onClick(view);
                }
            }
        });
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
        private TextView tvSubTitle;

        public ViewHolder(View view) {
            super(view);
            rootView = view;
            ivIcon = (ImageView) view.findViewById(R.id.ivIcon);
            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            vLine = (View) view.findViewById(R.id.vLine);
            ivArrow = (ImageView) view.findViewById(R.id.ivArrow);
            tvNum = (TextView) view.findViewById(R.id.tvNum);
            tvSubTitle = (TextView) view.findViewById(R.id.tvSubTitle);
        }
    }

    public interface OnClickItemListener {
        void onClick(View view);
    }
}
