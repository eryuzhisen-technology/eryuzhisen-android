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

public class PhoneEntity extends BaseEntity {

    private ViewHolder holder;

    public String getPhoneNum() {
        if (holder != null) {
            return holder.etPhone.getText().toString();
        }
        return null;
    }

    @Override
    public int getEntityType() {
        return EntityType_LoginPhone;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder) {
        this.holder = (ViewHolder) holder;
    }

    public static RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_login_phone, parent, false);
        return new ViewHolder(view);
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        private EditText etPhone;

        public ViewHolder(View view) {
            super(view);
            etPhone = (EditText) view.findViewById(R.id.etPhone);
        }
    }
}
