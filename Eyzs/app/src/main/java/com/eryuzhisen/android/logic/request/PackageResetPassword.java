package com.eryuzhisen.android.logic.request;

import com.eryuzhisen.android.logic.api.UrlData;
import com.eryuzhisen.android.model.bean.EyzsUserBean;
import com.eryuzhisen.android.utils.StringUtils;
import com.google.gson.Gson;

/**
 * @actor:taotao
 * @DATE: 2017/8/22
 */

public class PackageResetPassword {
    public static class EyzsResetPasswordReq extends EyzsBaseReq {

        private static final long serialVersionUID = 3075217017915666938L;
        private String phone_num;
        private String password;
        private String phone_vcode;


        public EyzsResetPasswordReq(UrlData urlData, int command) {
            super(urlData, command);
        }

        public String getPhone_num() {
            return phone_num;
        }

        public void setPhone_num(String phone_num) {
            this.phone_num = phone_num;
            this.params.put("phone_num", this.phone_num);
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
            this.params.put("password", this.password);
        }

        public String getPhone_vcode() {
            return phone_vcode;
        }

        public void setPhone_vcode(String phone_vcode) {
            this.phone_vcode = phone_vcode;
            this.params.put("phone_vcode", this.phone_vcode);
        }

        @Override
        public Object parseResponse(String json) {
            Gson gson = new Gson();
            return gson.fromJson(json,EyzsResetPasswordResp.class);
        }
    }

    public static class EyzsResetPasswordResp extends EyzsBaseResp {
        private static final long serialVersionUID = 6285226207060344149L;
    }

}
