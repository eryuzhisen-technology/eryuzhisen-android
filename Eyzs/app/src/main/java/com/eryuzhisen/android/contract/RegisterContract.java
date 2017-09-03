package com.eryuzhisen.android.contract;

import com.eryuzhisen.android.logic.event.PicVcodeEvent;
import com.na.mvp.contracts.NaContract;

import java.util.List;

/**
 * @actor:taotao
 * @DATE: 2017/7/29
 */

public interface RegisterContract {
    interface Presenter extends NaContract.Presenter{
        List getData();
        void updateData();
        void register(String phone, String pwd, String msgCode);
        void getMsgCode(String phone, String pcode);
        void getPicCode();
    }

    interface View extends NaContract.View{
        void onUpdate();
        void onPicVcode(byte[] img);
        void onMsgVcode(boolean isSuccess);
        void onRegister(boolean isSuccess);
    }

    interface Model extends NaContract.Model{
        List getData();
        void setPicVcodeEvent(PicVcodeEvent event);
    }
}
