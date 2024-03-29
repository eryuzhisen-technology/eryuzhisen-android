package com.eryuzhisen.android.logic;

import android.os.Message;

import com.eryuzhisen.android.logic.event.BannerEvent;
import com.eryuzhisen.android.logic.api.EyzsApi;
import com.eryuzhisen.android.logic.api.UrlData;
import com.eryuzhisen.android.logic.request.PackageBanner;
import com.eryuzhisen.android.logic.bean.BannerBean;
import com.na.mvp.net.CoreHandler;
import com.na.mvp.net.OkHttp;
import com.na.mvp.net.request.LogicBaseReq;
import com.na.mvp.rxbus.NaRxBus;

import java.util.List;

/**
 * @actor:taotao
 * @DATE: 2017/8/23
 */

public class LogicBanner extends CoreHandler {

    private static LogicBanner ourInstance = new LogicBanner();
    private List<BannerBean> mBannerList = null;
    private boolean isGetBanner = false;

    private LogicBanner() {

    }

    public static LogicBanner getInstance() {
        if (!NaRxBus.getRxBus().isRegistered(ourInstance)) {
            NaRxBus.getRxBus().register(ourInstance);
        }
        return ourInstance;
    }

    @Override
    public void onAsynThread(Message msg) {

    }

    @Override
    public void onMainThread(Message msg) {
        if (msg.what == Constants.CommandHomeBanner) {
            boolean isSuccess = false;
            if(msg.obj != null) {
                PackageBanner.EyzsBannerResp resq = (PackageBanner.EyzsBannerResp) msg.obj;
                if(resq.isSuccess()){
                    mBannerList = resq.getList();
                    isSuccess = true;
                }
            }

            BannerEvent event = new BannerEvent();
            event.setSuccess(isSuccess);
            NaRxBus.getRxBus().post(event);
        }
    }

    @Override
    public void onHttpResponse(LogicBaseReq req, Object resp) {
        if (req != null && req.getCommandId() == Constants.CommandHomeBanner) {
            sendToMainThread(req.getCommandId(), 0, 0, resp);
        }
    }

    public List<BannerBean> getBannerList() {
        return mBannerList;
    }

    public void getBannerListFromNet(){
        if(isGetBanner){
            return;
        }
        UrlData data = EyzsApi.getEyzsApi().getApiUrlData(EyzsApi.UrlDataKeyHomeBanner);
        PackageBanner.EyzsBannerReq req = new PackageBanner.EyzsBannerReq(data, Constants.CommandHomeBanner);
        OkHttp.getInstance().request(req);
        isGetBanner = true;
    }
}
