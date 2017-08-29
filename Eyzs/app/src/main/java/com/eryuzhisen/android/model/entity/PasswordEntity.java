package com.eryuzhisen.android.model.entity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.eryuzhisen.android.R;

/**
 * @actor:taotao
 * @DATE: 2017/8/27
 */

public class PasswordEntity extends BaseEntity {
    private int hintResId = 0;
    private ViewHolder holder;

    public String getPassword(){
        if (holder != null){
            return holder.etPassword.getText().toString();
        }
        return null;
    }

    public void setHintResId(int hintResId) {
        this.hintResId = hintResId;
    }

    @Override
    public int getEntityType() {
        return EntityType_LoginPassword;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder) {
        ViewHolder hd = (ViewHolder) holder;
        this.holder = hd;
        if(hintResId != 0) {
            hd.etPassword.setHint(hintResId);
        }
    }

    public static RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_login_password, parent, false);
        return new ViewHolder(view);
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        private EditText etPassword;

        public ViewHolder(View view) {
            super(view);
            etPassword = (EditText) view.findViewById(R.id.etPassword);
        }
    }
}
