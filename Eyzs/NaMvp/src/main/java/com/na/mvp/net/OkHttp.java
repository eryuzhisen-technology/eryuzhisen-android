package com.na.mvp.net;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.na.mvp.NaApp;
import com.na.mvp.log.NaLog;
import com.na.mvp.net.request.LogicBaseReq;
import com.na.mvp.rxbus.NaRxBus;
import com.na.mvp.utils.NetUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by joy on 16/9/21.
 */
public class OkHttp {
    private static final String TAG = "OkHttp";
    private static final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS);


    private static OkHttp ourInstance = new OkHttp();

    public static OkHttp getInstance() {
        if (!NaRxBus.getRxBus().isRegistered(ourInstance)) {
            NaRxBus.getRxBus().register(ourInstance);
        }
        return ourInstance;
    }


    private OkHttpClient client;

    private OkHttp() {
        X509TrustManager xtm = new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                X509Certificate[] x509Certificates = new X509Certificate[0];
                return x509Certificates;
            }
        };

        SSLContext sslContext = null;
        try {
            sslContext = SSLContext.getInstance("SSL");

            sslContext.init(null, new TrustManager[]{xtm}, new SecureRandom());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };
        client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
//        .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .sslSocketFactory(sslContext.getSocketFactory(), xtm)
                .build();

    }

    public void request(LogicBaseReq req) {
        if (req == null) {
            return;
        }
        if (isNetworkAvailable()) {
            sendReqestToAsyn(req);
        } else {
            Toast.makeText(NaApp.getApp(), "Please check your connection", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 检查当前网络是否可用
     *
     * @return
     */

    public boolean isNetworkAvailable() {
        Context context = NaApp.getApp();
        return NetUtils.isConnected(context);
    }

    private Request buildRequest(LogicBaseReq req) {
        Request.Builder builder = new Request.Builder();
        builder.url(req.getUrl());
        if (req.getHeaders().size() > 0) {
            builder.headers(Headers.of(req.getHeaders()));
        }
        if (req.getMethod() == LogicBaseReq.HTTP_POST) {
//            builder.post(RequestBody.create(MediaType.parse(req.getContentType()),req.getHttpEntity()));
//            FormBody.Builder formBodyBuilder = new FormBody.Builder();
//            if (req.getNameValueParams().size() > 0) {
//                for (Map.Entry<String, String> param : req.getNameValueParams().entrySet()) {
//                    String name = param.getKey();
//                    String value = param.getValue();
//                    if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(value)) {
//                        formBodyBuilder.add(name, value);
//                        System.out.println("参数: " + name + ":" + value);
//                    }
//
//                }
//            }

//            RequestBody formBody = formBodyBuilder.build();
            RequestBody formBody = RequestBody.create(MediaType.parse(req.getContentType()),req.getHttpEntity());
            builder.post(formBody);
        } else if (req.getMethod() == LogicBaseReq.HTTP_PUT) {

//            FormBody.Builder formBodyBuilder = new FormBody.Builder();
//            if (req.getNameValueParams().size() > 0) {
//                for (Map.Entry<String, String> param : req.getNameValueParams().entrySet()) {
//                    String name = param.getKey();
//                    String value = TextUtils.isEmpty(param.getValue()) ? "" : param.getValue();
////                    if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(value)){
//                    formBodyBuilder.add(name, value);
//                    System.out.println("参数: " + name + ":" + value);
////                    }
//
//                }
//            }
//            RequestBody formBody = formBodyBuilder.build();
            RequestBody formBody = RequestBody.create(MediaType.parse(req.getContentType()),req.getHttpEntity());
            builder.put(formBody);
        } else if (req.getMethod() == LogicBaseReq.HTTP_DELETE){
//            FormBody.Builder formBodyBuilder = new FormBody.Builder();
//            if (req.getNameValueParams().size() > 0) {
//                for (Map.Entry<String, String> param : req.getNameValueParams().entrySet()) {
//                    String name = param.getKey();
//                    String value = TextUtils.isEmpty(param.getValue()) ? "" : param.getValue();
////                    if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(value)){
//                    formBodyBuilder.add(name, value);
//                    System.out.println("参数: " + name + ":" + value);
////                    }
//
//                }
//            }
//            RequestBody formBody = formBodyBuilder.build();
            RequestBody formBody = RequestBody.create(MediaType.parse(req.getContentType()),req.getHttpEntity());
            builder.delete(formBody);
        }
        builder.tag(req);
        return builder.build();
    }

//    private Request buildFormRequest(PackageUploadImage.UploadImageRequest request) {
//        MultipartBody.Builder bodyBuilder = new MultipartBody.Builder();
//        bodyBuilder.setType(MultipartBody.FORM);
//        if (request.getFile() != null){
//            File file = request.getFile();
//            bodyBuilder.addFormDataPart("fileUpload", file.getName(), RequestBody.create(MediaType.parse(request.getContentType()), file));
//        }
//        if (request.getNameValueParams().size() > 0) {
//            for (Map.Entry<String, String> param : request.getNameValueParams().entrySet()) {
//                bodyBuilder.addFormDataPart(param.getKey(),param.getValue());
//            }
//        }
//
//        RequestBody requestBody = bodyBuilder.build();
//        Request req = new Request.Builder()
//                .url(request.getUrl())
//                .post(requestBody)
//                .tag(request)
//                .build();
//        return req;
//
//    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void execute(Event.HttpReqEvent reqEvent) {
        if (reqEvent == null || reqEvent.req == null) {
            // TODO: 16/9/21 请求为空处理
        }

        Request request = reqEvent.req;
        Response response = null;
        String respStr = null;
        try {
            NaLog.d(TAG, "naRxbus-http发起请求 url-" + request.url().toString());
            response = client.newCall(request).execute();
            respStr = new String(response.body().bytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        NaLog.d(TAG, "naRxbus-http返回值 url-" + request.url().toString() + " 返回值" + respStr);
        sendResponseToAsyn(request, respStr);
    }

    /**
     * 发送请求到子线程
     *
     * @param req
     */
    private void sendReqestToAsyn(LogicBaseReq req) {
        Event.HttpReqEvent reqEvent = new Event.HttpReqEvent();
//        if (req instanceof PackageUploadImage.UploadImageRequest){
//            PackageUploadImage.UploadImageRequest request = (PackageUploadImage.UploadImageRequest) req;
//            reqEvent.req = buildFormRequest(request);
//        }else{
        reqEvent.req = buildRequest(req);
//        }
        NaRxBus.getRxBus().post(reqEvent);
    }

    /**
     * 发送http返回结果到 CoreHandler.onHttpThreadRecv
     *
     * @param request
     * @param response
     */
    private void sendResponseToAsyn(Request request, String response) {
        Event.HttpRespEvent respEvent = new Event.HttpRespEvent();
        respEvent.req = (LogicBaseReq) request.tag();
        if (respEvent.req != null) {
            respEvent.resp = respEvent.req.parseResponse(response);
        }
//        respEvent.resp = new LogicBaseResp();
        NaRxBus.getRxBus().post(respEvent);
    }

}
