package com.eryuzhisen.android.model.entity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.eryuzhisen.android.R;
import com.eryuzhisen.android.utils.StringUtils;

/**
 * @actor:taotao
 * @DATE: 2017/8/27
 */

public class LoginButtonEntity extends BaseEntity {
    private int textResId = 0;
    private String text;
    private Listener listener;

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTextResId(int textResId) {
        this.textResId = textResId;
    }

    @Override
    public int getEntityType() {
        return EntityType_LoginButton;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder) {
        ViewHolder hd = (ViewHolder) holder;
        if(!StringUtils.isEmpty(text)){
            hd.tvButton.setText(text);
        } else {
            hd.tvButton.setText(textResId);
        }
        hd.tvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null){
                    listener.onClick();
                }
            }
        });
    }

    public static RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_login_button, parent, false);
        return new ViewHolder(view);
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        private Button tvButton;
        public ViewHolder(View view) {
            super(view);
            tvButton = (Button) view.findViewById(R.id.tvButton);
        }
    }

    public interface Listener{
        void onClick();
    }
}
