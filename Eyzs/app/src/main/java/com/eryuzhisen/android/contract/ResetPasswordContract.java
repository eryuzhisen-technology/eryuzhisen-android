package com.eryuzhisen.android.contract;

import com.na.mvp.contracts.NaContract;

import java.util.List;

/**
 * @actor:taotao
 * @DATE: 2017/7/29
 */

public interface ResetPasswordContract {
    interface Presenter extends NaContract.Presenter{
        List getData();
        void updateData();
        void resetPassword(String phone, String pwd, String msgCode);
        void getMsgCode(String phone, String pcode);
        void getPicCode();
    }

    interface View extends NaContract.View{
        void onUpdate();
        void onPicVcode(byte[] img);
        void onMsgVcode(boolean isSuccess);
        void onResetPwd(boolean isSuccess);
    }

    interface Model extends NaContract.Model{
        List getData();
    }
}
