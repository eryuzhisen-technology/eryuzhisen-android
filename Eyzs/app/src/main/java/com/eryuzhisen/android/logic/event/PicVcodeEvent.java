package com.eryuzhisen.android.logic.event;

import com.eryuzhisen.android.utils.Base64;
import com.eryuzhisen.android.utils.StringUtils;

/**
 * @actor:taotao
 * @DATE: 2017/8/28
 */

public class PicVcodeEvent extends BaseEvent{
    private String vcodeId;
    private String picVcode;

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
