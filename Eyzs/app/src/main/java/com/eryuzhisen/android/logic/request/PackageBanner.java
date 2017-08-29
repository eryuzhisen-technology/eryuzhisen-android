package com.eryuzhisen.android.logic.request;

import com.eryuzhisen.android.logic.api.UrlData;
import com.eryuzhisen.android.model.bean.BannerBean;
import com.google.gson.Gson;

import java.util.List;

/**
 * @actor:taotao
 * @DATE: 2017/8/23
 */

public class PackageBanner {
    public static class EyzsBannerReq extends EyzsBaseReq {
        private static final long serialVersionUID = -7856795046670048262L;

        public EyzsBannerReq(UrlData urlData, int command) {
            super(urlData, command);
        }

        @Override
        public Object parseResponse(String json) {
            Gson gson = new Gson();
            return gson.fromJson(json, EyzsBannerResp.class);
        }
    }

    public static class EyzsBannerResp extends EyzsBaseResp {
        private static final long serialVersionUID = 4777100921307842303L;
        private List<BannerBean> list;
    }
}
