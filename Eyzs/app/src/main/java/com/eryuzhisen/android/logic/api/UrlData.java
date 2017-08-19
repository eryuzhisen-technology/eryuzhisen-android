package com.eryuzhisen.android.logic.api;

/**
 * @actor:taotao
 * @DATE: 2017/8/19
 */

public class UrlData {
    public final static String TypeHttpGet = "Get";
    public final static String TypeHttpPost = "Post";
    public final static String TypeHttpPut = "Put";
    public final static String TypeHttpDelete = "Delete";

    private String key;
    private long expires;
    private String netType;
    private String url;

    public UrlData(String key, String netType, String url) {
        this.key = key;
        this.netType = netType;
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public long getExpires() {
        return expires;
    }

    public String getNetType() {
        return netType;
    }

    public String getUrl() {
        return url;
    }

    public void setExpires(long expires) {
        this.expires = expires;
    }
}
