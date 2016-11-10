package com.gmail.mqh444.qzhihu.business.api.impl.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * RetrofitUtil
 * Created by Louis on 2016/11/10.
 */

public class RetrofitUtil {

    public static <T> T createApi(Class<T> tClass, OkHttpClient client){
        return new Retrofit.Builder()
                .client(client)
                .baseUrl("http://news-at.zhihu.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(tClass);
    }
}
