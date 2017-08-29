package com.eryuzhisen.android.model;

import com.eryuzhisen.android.R;
import com.eryuzhisen.android.contract.ResetPasswordContract;
import com.eryuzhisen.android.model.entity.LoginButtonEntity;
import com.eryuzhisen.android.model.entity.LoginTextEntity;
import com.eryuzhisen.android.model.entity.MsgVcodeEntity;
import com.eryuzhisen.android.model.entity.PasswordEntity;
import com.eryuzhisen.android.model.entity.PhoneEntity;
import com.eryuzhisen.android.model.entity.PicVcodeEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @actor:taotao
 * @DATE: 2017/8/27
 */

public class ResetPasswordModel implements ResetPasswordContract.Model {

    private PhoneEntity phoneItem;
    private PicVcodeEntity picVcodeItem;
    private MsgVcodeEntity msgVcodeIten;
    private PasswordEntity passwordItem;
    private PasswordEntity rePasswordItem;
    private LoginButtonEntity loginButtonItem;

    @Override
    public List getData() {
        List data = new ArrayList();
        if(phoneItem == null){
            phoneItem = new PhoneEntity();
        }
        data.add(phoneItem);

        if(picVcodeItem == null){
            picVcodeItem = new PicVcodeEntity();
        }
        data.add(picVcodeItem);

        if(msgVcodeIten == null){
            msgVcodeIten = new MsgVcodeEntity();
        }
        data.add(msgVcodeIten);

        if(passwordItem == null){
            passwordItem = new PasswordEntity();
        }
        data.add(passwordItem);

        if(rePasswordItem == null){
            rePasswordItem = new PasswordEntity();
            rePasswordItem.setHintResId(R.string.new_password);
        }
        data.add(rePasswordItem);

        if(loginButtonItem == null) {
            loginButtonItem = new LoginButtonEntity();
            loginButtonItem.setTextResId(R.string.save_login);
        }
        data.add(loginButtonItem);
        return data;
    }
}
