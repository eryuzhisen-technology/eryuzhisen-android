package com.na.mvp.presenters;

import com.na.mvp.contracts.NaContract;
import com.na.mvp.rxbus.NaRxBus;

/**
 * @actor:taotao
 * @DATE: 2017/7/29
 */

public class NaBasePresenter <T extends NaContract.View, E extends NaContract.Model> {
    protected T view;
    protected E model;

    public void init(Object view, Object model) {
        this.view = (T) view;
        this.model = (E) model;
    }

    public void start() {
        if(isRegisterNaRxBus()){
            NaRxBus.get().register(this);
        }
    }

    public void destroy() {
        view = null;
        model = null;
        if(isRegisterNaRxBus()){
            NaRxBus.get().unregister(this);
        }
    }

    public boolean isRegisterNaRxBus(){
        return false;
    }
}
