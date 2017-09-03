package com.eryuzhisen.android.logic.request;

import com.eryuzhisen.android.logic.api.UrlData;
import com.eryuzhisen.android.logic.bean.EyzsUserBean;
import com.google.gson.Gson;

/**
 * @actor:taotao
 * @DATE: 2017/8/22
 */

public class PackageLogin {
    public static class EyzsLoginReq extends EyzsBaseReq {

        private static final long serialVersionUID = -3527476172454624519L;
        //        "phone_num":"xxxxx",//手机号
//        "password":"xxxx",//密码
//        "device_no":"xxx",//设备号,没有则新生成一个,统计用
//        "pic_vid":"xxxx",//密码错误次数超过5次时,需要单独调用图形验证码
//         "pic_vcode":"xxxx",//密码错误5超过5次,需要校验图形验证码
        private String phone_num;
        private String password;
        private String device_no;
        private String pic_vid;
        private String pic_vcode;

        public EyzsLoginReq(UrlData urlData, int command) {
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

        public String getDevice_no() {
            return device_no;
        }

        public void setDevice_no(String device_no) {
            this.device_no = device_no;
            this.params.put("device_no", this.device_no);
        }

        public String getPic_vid() {
            return pic_vid;
        }

        public void setPic_vid(String pic_vid) {
            this.pic_vid = pic_vid;
            this.params.put("pic_vid", this.pic_vid);
        }

        public String getPic_vcode() {
            return pic_vcode;
        }

        public void setPic_vcode(String pic_vcode) {
            this.pic_vcode = pic_vcode;
            this.params.put("pic_vcode", this.pic_vcode);
        }

        @Override
        public String getHttpEntity() {
            Gson gson = new Gson();
            return gson.toJson(this);
        }

        @Override
        public Object parseResponse(String json) {
            Gson gson = new Gson();
            return gson.fromJson(json, EyzsLoginResp.class);
        }
    }

    public static class EyzsLoginResp extends EyzsBaseResp {

        private static final long serialVersionUID = 5852965748102275489L;
        //"token":"xxxx",//目前有效期7天 后期协议需要在header中带上校验
        // "device_no":"xxxx",//设备号,request传入原样返回,没有则新生成
        //"info_status":"1"//用户资料完整度状态 1:已完善 预留字段,目前没有强制用户输入某些信息
        private String token;
        private String device_no;
        private String info_status;
        private String uid;
        private EyzsUserBean user;

        public EyzsUserBean getUser() {
            return user;
        }

        public void setUser(EyzsUserBean user) {
            this.user = user;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getDevice_no() {
            return device_no;
        }

        public void setDevice_no(String device_no) {
            this.device_no = device_no;
        }

        public String getInfo_status() {
            return info_status;
        }

        public void setInfo_status(String info_status) {
            this.info_status = info_status;
        }
    }

}
