package com.na.mvp.net.request;

import java.io.Serializable;
import java.util.HashMap;


public abstract class LogicBaseReq implements Serializable {

    public static final String CONTENT_TYPE_GSON = "application/json;charset=UTF-8";
    public static final String CONTENT_TYPE_URLENCODED = "application/x-www-form-urlencoded;charset=UTF-8";


    public static final int HTTP_GET = 0;
    public static final int HTTP_POST = 1;
    public static final int HTTP_PUT = 2;
    private static final long serialVersionUID = 3847698786992680183L;

    private transient HashMap<String,String> headers = new HashMap<>();
    protected transient HashMap<String,String> params = new HashMap<>();
    protected transient int commandId;

    public LogicBaseReq(){
//        headers.put("","");
    }

    public abstract String getUrl();

    public abstract int getMethod();

    public abstract String getHttpEntity();

    public abstract String getContentType();

    public abstract Object parseResponse(String json);

    public HashMap<String, String> getHeaders() {
        return headers;
    }

    public int getCommandId() {
        return commandId;
    }

    public void setCommandId(int commandId) {
        this.commandId = commandId;
    }

    public void addHeader(String name, String value){
        headers.put(name,value);
    }

    public HashMap<String,String> getNameValueParams(){
        return params;
    }

}
