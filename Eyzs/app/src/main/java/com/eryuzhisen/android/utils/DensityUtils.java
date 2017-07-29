package com.eryuzhisen.android.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;

/**
 * Created by joy on 16/10/19.
 */
public class DensityUtils {


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int getScrrenWidth(Activity context){
        Point point = new Point();
        context.getWindowManager().getDefaultDisplay().getSize(point);
        return point.x;
    }

    public static int getScrrenHeight(Activity context){
        Point point = new Point();
        context.getWindowManager().getDefaultDisplay().getSize(point);
        System.out.println("scrren height:"+point.y);
        return point.y;
    }

    public static int getStatusBarHeight(Activity activity){
        int statusBarHeight = -1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusBarHeight = activity.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusBarHeight;
    }

}
