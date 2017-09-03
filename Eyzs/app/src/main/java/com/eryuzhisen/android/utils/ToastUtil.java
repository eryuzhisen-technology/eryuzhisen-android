package com.eryuzhisen.android.utils;

import android.widget.Toast;

import com.eryuzhisen.android.EyzsApplication;

/**
 * @actor:taotao
 * @DATE: 2017/9/2
 */

public class ToastUtil {

    public static void showTextShort(String text) {
        if(!StringUtils.isEmpty(text)){
            Toast.makeText(EyzsApplication.getApp(), text, Toast.LENGTH_SHORT);
        }
    }
}
