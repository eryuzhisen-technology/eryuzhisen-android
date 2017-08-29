package com.eryuzhisen.android.event;

import com.eryuzhisen.android.utils.Base64;
import com.eryuzhisen.android.utils.StringUtils;

/**
 * @actor:taotao
 * @DATE: 2017/8/28
 */

public class PicVcodeEvent {
    private boolean isSuccess;
    private String vcodeId;
    private String picVcode;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public void setVcodeId(String vcodeId) {
        this.vcodeId = vcodeId;
    }

    public void setPicVcode(String picVcode) {
        this.picVcode = picVcode;
    }

    public String getVcodeId() {
        return vcodeId;
    }

    public String getPicVcode() {
        return picVcode;
    }

    public byte[] getPicVcodeImg() {
        if(!StringUtils.isEmpty(picVcode)){
            return Base64.decode(picVcode, Base64.DEFAULT);
        }
        return null;
    }
}
