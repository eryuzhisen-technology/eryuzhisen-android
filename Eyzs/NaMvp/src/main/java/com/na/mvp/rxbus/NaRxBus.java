package com.na.mvp.rxbus;

import org.greenrobot.eventbus.EventBus;

/**
 * @actor:taotao
 * @DATE: 2017/8/19
 */

public class NaRxBus {

    public static NaRxBus naRxBus = new NaRxBus();
    private EventBus eventBus;

    private NaRxBus() {
        eventBus = EventBus.getDefault();
    }

    public static NaRxBus getRxBus(){
        return naRxBus;
    }

    public void register(Object subscriber){
        eventBus.register(subscriber);
    }

    public void unregister(Object subscriber){
        eventBus.unregister(subscriber);
    }

    public boolean isRegistered(Object subscriber){
        return eventBus.isRegistered(subscriber);
    }

    public void post(Object event){
        eventBus.post(event);
    }
}
