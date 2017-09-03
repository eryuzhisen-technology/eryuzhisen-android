package com.eryuzhisen.android.common;

/**
 * @actor:taotao
 * @DATE: 2017/8/30
 */

public final class EyzsUserInfo {
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
    private String uid;
    private String nickName;
    private String gender;
    private String avatar;
    private String deviceNo;
    private String age;
    private String signature;

    public EyzsUserInfo(String uid, String nickName, String gender, String avatar) {
        this.uid = uid;
        this.nickName = nickName;
        this.gender = gender;
        this.avatar = avatar;
    }

    public EyzsUserInfo() {
    }

    public String getUid() {
        return uid;
    }

    public String getNickName() {
        return nickName;
    }

    public String getGender() {
        return gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}

