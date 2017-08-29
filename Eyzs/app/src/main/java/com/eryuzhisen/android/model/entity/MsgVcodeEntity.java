package com.eryuzhisen.android.model.entity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.eryuzhisen.android.R;
import com.eryuzhisen.android.logic.LogicLogin;

/**
 * @actor:taotao
 * @DATE: 2017/8/27
 */

public class MsgVcodeEntity extends BaseEntity {
    private ViewHolder holder;
    private Listener listener;

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public ViewHolder getHolder() {
        return holder;
    }

    public void setHolder(ViewHolder holder) {
        this.holder = holder;
    }

    @Override
    public int getEntityType() {
        return EntityType_LoginMsgVcode;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder) {
        this.holder = (ViewHolder) holder;
        this.holder.tvVcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null){
                    listener.onGetVcode();
                }
            }
        });
    }

    public static RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_login_msg_vcode, parent, false);
        return new ViewHolder(view);
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvVcode;
        private EditText etPicVcode;
        public ViewHolder(View view) {
            super(view);
            tvVcode = (TextView) view.findViewById(R.id.tvVcode);
            etPicVcode = (EditText) view.findViewById(R.id.etPicVcode);
        }
    }

    public interface Listener{
        void onGetVcode();
    }
}
