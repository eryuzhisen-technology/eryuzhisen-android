package com.eryuzhisen.android.logic.request;

import com.eryuzhisen.android.logic.api.UrlData;
import com.google.gson.Gson;

/**
 * @actor:taotao
 * @DATE: 2017/8/24
 */

public class PackagePhoneVerifyCode {
    public static class EyzsPhoneVerifyCodeReq extends EyzsBaseReq {

        private static final long serialVersionUID = -4352774338360177150L;
        private String verifyType;
        private String phoneNum;
        private String picVcode;
        private String picVid;

        public EyzsPhoneVerifyCodeReq(UrlData urlData, int command) {
            super(urlData, command);
        }

        public String getVerifyType() {
            return verifyType;
        }

        public void setVerifyType(String verifyType) {
            this.verifyType = verifyType;
        }

        public String getPhoneNum() {
            return phoneNum;
        }

        public void setPhoneNum(String phoneNum) {
            this.phoneNum = phoneNum;
        }

        public String getPicVcode() {
            return picVcode;
        }

        public void setPicVcode(String picVcode) {
            this.picVcode = picVcode;
        }

        @Override
        public String getUrl() {
            String url = super.getUrl();
            return url + "?verifyType=" + verifyType + "&phoneNum="
                    + phoneNum + "&picVcode=" + picVcode + "&picVid=" + picVid;
        }

        public String getPicVid() {
            return picVid;
        }

        public void setPicVid(String picVid) {
            this.picVid = picVid;
            this.params.put("picVid", picVid);
        }

        @Override
        public Object parseResponse(String json) {
            Gson gson = new Gson();
            return gson.fromJson(json, EyzsPhoneVerifyCodeResp.class);
        }
    }

    public static class EyzsPhoneVerifyCodeResp extends EyzsBaseResp {

        private static final long serialVersionUID = -6018571023254377818L;
        private String phone_num;

        public String getPhone_num() {
            return phone_num;
        }
    }
}
