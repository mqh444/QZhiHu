package com.gmail.mqh444.qzhihu.business.api.impl;

import com.gmail.mqh444.qzhihu.core.log.XLog;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * OkHttpUtil
 * Created by Louis on 2016/11/9.
 */

public class OkHttpUtil {

    private static final int HTTP_TIME_OUT = 15;

    public static OkHttpClient newOkHttpClient(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        // set time interval
        builder.readTimeout(HTTP_TIME_OUT, TimeUnit.MINUTES);
        builder.connectTimeout(HTTP_TIME_OUT,TimeUnit.MINUTES);
        builder.writeTimeout(HTTP_TIME_OUT,TimeUnit.MINUTES);
        builder.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);
                XLog.i("Interceptor:request = %s, response = %s", request,response);
                return response;
            }
        });
        return builder.build();
    }

    public static CacheControl getCacheControl(){
        return new CacheControl.Builder().noCache().build();
    }

    private OkHttpUtil(){
    }
}
