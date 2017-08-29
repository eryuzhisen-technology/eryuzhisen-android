package com.eryuzhisen.android.model.bean;

import java.util.Map;

/**
 * @actor:taotao
 * @DATE: 2017/8/23
 */

public class EyzsJumpui {
//    "jumpui":{
//        "page_id":"xx",//跳转的页面id,后期协商
//                "arguments":{"":""},//跳转某个页面需要带的参数,后期协商
    private String page_id;
    private Map<String, String> arguments;

    public String getPage_id() {
        return page_id;
    }

    public void setPage_id(String page_id) {
        this.page_id = page_id;
    }

    public Map<String, String> getArguments() {
        return arguments;
    }

    public void setArguments(Map<String, String> arguments) {
        this.arguments = arguments;
    }
}
