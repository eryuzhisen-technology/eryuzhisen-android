package com.eryuzhisen.android.model.entity;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * @actor:taotao
 * @DATE: 2017/8/12
 */

public abstract class BaseEntity {

    public static final int EntityType_SetItem = 1;
    public static final int EntityType_SetInterval = 2;
    public static final int EntityType_LoginPhone = 3;
    public static final int EntityType_LoginPassword = 4;
    public static final int EntityType_LoginPicVcode = 5;
    public static final int EntityType_LoginMsgVcode = 6;
    public static final int EntityType_LoginText = 7;
    public static final int EntityType_LoginButton = 8;



    public abstract int getEntityType();

    public static RecyclerView.ViewHolder createViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        switch (viewType){
            case EntityType_SetItem:{
                holder = SetItemEntity.onCreateViewHolder(parent);
                break;
            }
            case EntityType_SetInterval:{
                holder = SetIntervalEntity.onCreateViewHolder(parent);
                break;
            }
            case EntityType_LoginPhone:{
                holder = PhoneEntity.onCreateViewHolder(parent);
                break;
            }
            case EntityType_LoginPassword:{
                holder = PasswordEntity.onCreateViewHolder(parent);
                break;
            }case EntityType_LoginPicVcode:{
                holder = PicVcodeEntity.onCreateViewHolder(parent);
                break;
            }
            case EntityType_LoginMsgVcode:{
                holder = MsgVcodeEntity.onCreateViewHolder(parent);
                break;
            }
            case EntityType_LoginText:{
                holder = LoginTextEntity.onCreateViewHolder(parent);
                break;
            }
            case EntityType_LoginButton:{
                holder = LoginButtonEntity.onCreateViewHolder(parent);
                break;
            }
            default:{
                break;
            }
        }
        return holder;
    }

    public abstract void onBindViewHolder(RecyclerView.ViewHolder holder);
}
