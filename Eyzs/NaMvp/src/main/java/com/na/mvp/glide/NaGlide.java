package com.na.mvp.glide;

import android.app.Activity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;


/**
 * @actor:taotao
 * @DATE: 2017/8/28
 */

public class NaGlide {
    public static RequestManager with(Activity activity){
        return Glide.with(activity);
    }


}
