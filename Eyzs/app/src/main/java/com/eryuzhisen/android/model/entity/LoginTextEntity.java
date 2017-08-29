package com.eryuzhisen.android.model.entity;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eryuzhisen.android.R;
import com.eryuzhisen.android.activity.ActivityManager;
import com.eryuzhisen.android.utils.StringUtils;

/**
 * @actor:taotao
 * @DATE: 2017/8/27
 */

public class LoginTextEntity extends BaseEntity {
    private int textResId = 0;
    private String text;
    private boolean isForgotPwd = false;

    public void setForgotPwd(boolean forgotPwd) {
        isForgotPwd = forgotPwd;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTextResId(int textResId) {
        this.textResId = textResId;
    }

    @Override
    public int getEntityType() {
        return EntityType_LoginText;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder) {
        final ViewHolder hd = (ViewHolder) holder;
        if(!StringUtils.isEmpty(text)){
            hd.tvText.setText(text);
        } else {
            hd.tvText.setText(textResId);
        }

        if(isForgotPwd){
            hd.tvText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Activity activity = (Activity) hd.tvText.getContext();
                    ActivityManager.getInstance().jumpToActivity(activity, ActivityManager.reset_password);
                }
            });
        }
    }

    public static RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_login_text, parent, false);
        return new ViewHolder(view);
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvText;
        public ViewHolder(View view) {
            super(view);
            tvText = (TextView) view.findViewById(R.id.tvText);
        }
    }
}
