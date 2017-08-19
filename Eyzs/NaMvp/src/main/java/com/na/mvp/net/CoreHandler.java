package com.na.mvp.net;

import android.os.Message;

import com.na.mvp.net.request.LogicBaseReq;
import com.na.mvp.rxbus.NaRxBus;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


/**
 * Created by joy on 16/9/20.
 */
public abstract class CoreHandler {

    public abstract void onAsynThread(Message msg);

    public abstract void onMainThread(Message msg);

    public abstract void onHttpResponse(LogicBaseReq req, Object resp);

    /**
     * eventbus不能设置抽象方法为订阅者@Subscribe,所以采取这种方式
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onAsynThreadRecv(Event.AsynEvent event) {
        onAsynThread(event.message);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMainThreadRecv(Event.MainEvent event) {
        onMainThread(event.message);
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onHttpThreadRecv(Event.HttpRespEvent event) {
        onHttpResponse(event.req, event.resp);
    }

    protected void sendToAsynThread(int what, int arg1, int arg2, Object obj) {
//        AsynThreadPool.getInstense().sendToAsynThread(what,arg1,arg2,obj);
        Event.AsynEvent asynEvent = new Event.AsynEvent();
        asynEvent.message = new Message();
        asynEvent.message.what = what;
        asynEvent.message.arg1 = arg1;
        asynEvent.message.arg2 = arg2;
        asynEvent.message.obj = obj;
        NaRxBus.getRxBus().post(asynEvent);

    }

    protected void sendToMainThread(int what, int arg1, int arg2, Object obj) {
//        AsynThreadPool.getInstense().sendToMainThread(what,arg1,arg2,obj);
        Event.MainEvent mainEvent = new Event.MainEvent();
        mainEvent.message = new Message();
        mainEvent.message.what = what;
        mainEvent.message.arg1 = arg1;
        mainEvent.message.arg2 = arg2;
        mainEvent.message.obj = obj;
        NaRxBus.getRxBus().post(mainEvent);
    }

}
