package com.eryuzhisen.android.logic.request;

import com.eryuzhisen.android.logic.api.UrlData;
import com.google.gson.Gson;

/**
 * @actor:taotao
 * @DATE: 2017/8/24
 */

public class PackagePicVerifyCode {
    public static class EyzsPicVerifyCodeReq extends EyzsBaseReq {


        private static final long serialVersionUID = -7871871551803389699L;

        public EyzsPicVerifyCodeReq(UrlData urlData, int command) {
            super(urlData, command);
        }

        @Override
        public Object parseResponse(String json) {
            Gson gson = new Gson();
            return gson.fromJson(json, EyzsPicVerifyCodeResp.class);
        }
    }

    public static class EyzsPicVerifyCodeResp extends EyzsBaseResp {

        private static final long serialVersionUID = -7069736650946277540L;
        // "pic_vid":"xxxxx",//图形验证码id
        // "pic_vcode":"xxxx"//图形验证码图片 base64编码
        private String pic_vid;
        private String pic_vcode;

        public String getPic_vid() {
            return pic_vid;
        }

        public String getPic_vcode() {
            return pic_vcode;
        }
    }
}
