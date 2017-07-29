package com.eryuzhisen.android.rxbus;

import com.hwangjr.rxbus.Bus;

/**
 * @actor:taotao
 * @DATE: 2017/7/29
 */

public final class NaRxBus {
    private static Bus sBus;

    public static synchronized Bus get() {
        if (sBus == null) {
            sBus = new Bus();
        }
        return sBus;
    }
}
