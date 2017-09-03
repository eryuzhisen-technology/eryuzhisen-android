package com.eryuzhisen.android.logic.request;

import com.eryuzhisen.android.logic.api.UrlData;
import com.eryuzhisen.android.logic.bean.EyzsUserBean;
import com.google.gson.Gson;

/**
 * @actor:taotao
 * @DATE: 2017/8/23
 */

public class PackageUserInfo {
    public static class EyzsUserInfoReq extends EyzsBaseReq {

        private static final long serialVersionUID = -1128845739037129754L;
        private String userId;

        public EyzsUserInfoReq(UrlData urlData, int command) {
            super(urlData, command);
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        @Override
        public String getUrl() {
            return super.getUrl() + "?userId=" + userId;
        }

        @Override
        public Object parseResponse(String json) {
            Gson gson = new Gson();
            return gson.fromJson(json, EyzsUserInfoResp.class);
        }
    }

    public static class EyzsUserInfoResp extends EyzsBaseResp {

        private static final long serialVersionUID = 8766022172498611803L;
        private EyzsUserBean info;
    }
}
