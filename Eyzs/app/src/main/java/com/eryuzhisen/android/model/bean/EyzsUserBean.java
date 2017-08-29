package com.eryuzhisen.android.model.bean;

/**
 * @actor:taotao
 * @DATE: 2017/8/24
 */

public class EyzsUserBean {
//    "user":{
//        "nick_name":"xxxx",//昵称
//                "avatar_url":"xxxx",//头像url
//                "signature":"xxx",//签名,
//                "c_age":"1年5个月12天",//论坛年龄
//    }
    private String nick_name;
    private String avatar_url;
    private String signature;
    private String c_age;

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getC_age() {
        return c_age;
    }

    public void setC_age(String c_age) {
        this.c_age = c_age;
    }
}
