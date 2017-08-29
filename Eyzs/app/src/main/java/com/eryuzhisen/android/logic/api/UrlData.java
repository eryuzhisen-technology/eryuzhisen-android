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
    public static final int HttpGet = 0;
    public static final int HttpPost = 1;
    public static final int HttpPut = 2;
    public static final int HttpDelete = 3;

    private String key;
    private long expires;
    private String netType;
    private String url;

    public UrlData(String key, String url, String netType) {
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

    public int getMethod() {
        int method = HttpGet;
        if (netType.equals(TypeHttpPost)) {
            method = HttpPost;
        } else if (netType.equals(TypeHttpPut)) {
            method = HttpPut;
        } else if (netType.equals(TypeHttpDelete)) {
            method = HttpDelete;
        }
        return method;
    }
}
