package com.eryuzhisen.android.model.entity;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.eryuzhisen.android.R;
import com.eryuzhisen.android.logic.event.PicVcodeEvent;
import com.na.mvp.glide.NaGlide;

/**
 * @actor:taotao
 * @DATE: 2017/8/27
 */

public class PicVcodeEntity extends BaseEntity{
    private PicVcodeEvent picVcodeEvent;
    private ViewHolder holder;
    private Listener listener;

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public String getPicVcode(){
        if(holder != null){
            return holder.etPicVcode.getText().toString();
        }
        return null;
    }

    public String getPicVcodeId(){
        if(picVcodeEvent != null){
            return picVcodeEvent.getVcodeId();
        }
        return null;
    }

    @Override
    public int getEntityType() {
        return EntityType_LoginPicVcode;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder hd) {
        holder = (ViewHolder) hd;
        if(holder != null) {
            holder.ivVcodeImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null){
                        listener.onGetVcode();
                    }
                }
            });

            if (picVcodeEvent != null) {
                Activity activity = (Activity) holder.etPicVcode.getContext();
                byte[] img = null;
                if (picVcodeEvent != null){
                    img = picVcodeEvent.getPicVcodeImg();
                }
                if(img != null && img.length > 0) {
                    NaGlide.with(activity).load(img).into(holder.ivVcodeImg);
                }
            }
        }

    }

    public static RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_login_picture_vcode, parent, false);
        return new ViewHolder(view);
    }

    public void setPicVcodeEvent(PicVcodeEvent picVcodeEvent) {
        this.picVcodeEvent = picVcodeEvent;
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivVcodeImg;
        private EditText etPicVcode;

        public ViewHolder(View view) {
            super(view);
            ivVcodeImg = (ImageView) view.findViewById(R.id.ivVcodeImg);
            etPicVcode = (EditText) view.findViewById(R.id.etPicVcode);
        }
    }

    public interface Listener{
        void onGetVcode();
    }
}
