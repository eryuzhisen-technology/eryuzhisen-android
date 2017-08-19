package com.na.mvp.net;

import android.os.Message;

import com.na.mvp.net.request.LogicBaseReq;

import okhttp3.Request;

/**
 * eventbus 事件类
 * Created by joy on 16/9/20.
 */
public class Event {

    public static class AsynEvent{
        public Message message;
    }

    public static class MainEvent{
        public Message message;
    }

    public static class HttpReqEvent{
        public Request req;
    }

    public static class HttpRespEvent{
        public LogicBaseReq req;
        public Object resp;
    }
}
