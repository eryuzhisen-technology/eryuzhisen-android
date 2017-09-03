package com.eryuzhisen.android.logic.request;

import com.eryuzhisen.android.logic.api.UrlData;
import com.eryuzhisen.android.logic.bean.EyzsUserBean;
import com.eryuzhisen.android.utils.StringUtils;
import com.google.gson.Gson;

/**
 * @actor:taotao
 * @DATE: 2017/8/22
 */

public class PackageRegister {
    public static class EyzsRegisterReq extends EyzsBaseReq {
        private static final long serialVersionUID = -300333653370395961L;
        private static final String DefaultInviteCode = "Bi1O1ssE";
        //        "phone_num":"xxxxx",//手机号
//        "password":"xxxx",//密码
//        "device_no":"xxx",//设备号,没有则新生成一个,统计用
//        "pic_vid":"xxxx",//密码错误次数超过5次时,需要单独调用图形验证码
//         "pic_vcode":"xxxx",//密码错误5超过5次,需要校验图形验证码
        private String phone_num;
        private String password;
        private String device_no;
        private String invite_code;
        private String phone_vcode;


        public EyzsRegisterReq(UrlData urlData, int command) {
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

        public String getInvite_code() {
            return invite_code;
        }

        public void setInvite_code(String invite_code) {
            if(StringUtils.isEmpty(invite_code)){
                invite_code = DefaultInviteCode;
            }
            this.invite_code = invite_code;
            this.params.put("invite_code", this.invite_code);
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
            return gson.fromJson(json,EyzsRegisterResp.class);
        }
    }

    public static class EyzsRegisterResp extends EyzsBaseResp {

        private static final long serialVersionUID = 1079878234996013388L;
        //        "token":"xxxx",//目前有效期7天 后期协议需要在header中带上校验
//                "device_no":"xxxx",//设备号,request传入原样返回,没有则新生成
//                "user":{
//            "nick_name":"xxxx",//昵称
//                    "avatar_url":"xxxx",//头像url
//                    "signature":"xxx",//签名,
//                    "c_age":"1年5个月12天",//论坛年龄
//        }
        private String token;
        private String device_no;
        private String uid;
        private EyzsUserBean user;

        public String getToken() {
            return token;
        }

        public String getDevice_no() {
            return device_no;
        }

        public EyzsUserBean getUser() {
            return user;
        }

        public String getUid() {
            return uid;
        }
    }

}
