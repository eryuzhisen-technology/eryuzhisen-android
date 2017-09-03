package com.eryuzhisen.android.logic.bean;

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
    private String gender;
    private String relation;
    private String black;
    private String opus_count;
    private String fans_count;
    private String device_no;

//    "uid":"xxxx",
//            "nick_name":"xxxxx",//昵称
//            "avatar_url":"xxxxx",//头像url
//            "signature":"xxxxx",//签名
//            "c_age":"xxx",//论坛年龄
//            "gender":"0"//0 保密 1 男 2 女
//            "relation":"0",//关系 0 没有关注 1 关注 2 粉丝 3 相互关注
//            "black":"0",//是否在黑名单 0 不在 1 在
//            "opus_count","20",//作品数量
//            "fans_count":"30"//粉丝数量

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getBlack() {
        return black;
    }

    public void setBlack(String black) {
        this.black = black;
    }

    public String getOpus_count() {
        return opus_count;
    }

    public void setOpus_count(String opus_count) {
        this.opus_count = opus_count;
    }

    public String getFans_count() {
        return fans_count;
    }

    public void setFans_count(String fans_count) {
        this.fans_count = fans_count;
    }

    public String getDevice_no() {
        return device_no;
    }

    public void setDevice_no(String device_no) {
        this.device_no = device_no;
    }
}
