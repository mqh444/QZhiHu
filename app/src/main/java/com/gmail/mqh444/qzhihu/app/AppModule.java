package com.gmail.mqh444.qzhihu.app;

import android.app.Application;

import com.gmail.mqh444.qzhihu.business.api.ZhihuApi;
import com.gmail.mqh444.qzhihu.business.api.impl.OkHttpUtil;
import com.gmail.mqh444.qzhihu.business.api.impl.okhttp.ZhihuApiOkHttpImpl;
import com.gmail.mqh444.qzhihu.business.api.impl.retrofit.IZhihuRetorfitApi;
import com.gmail.mqh444.qzhihu.business.api.impl.retrofit.RetrofitUtil;
import com.gmail.mqh444.qzhihu.business.api.impl.retrofit.ZhihuApiRetrofitImpl;
import com.gmail.mqh444.qzhihu.business.domain.ZhihuDomain;
import com.gmail.mqh444.qzhihu.business.domain.impl.ZhihuDomainImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * AppModule
 * Created by Louis on 2016/11/7.
 */
@Module
public class AppModule {

    private Application application;

    public AppModule(Application application){
        this.application = application;
    }

    @Provides
    public ZhihuDomain providerZhihuDomain(ZhihuApi zhihuApi){
        return new ZhihuDomainImpl(zhihuApi);
    }

    @Provides
    public ZhihuApi providerZhihuApi(IZhihuRetorfitApi zhihuRetorfitApi){
        return new ZhihuApiRetrofitImpl(zhihuRetorfitApi);
    }

    //@Provides
    public ZhihuApi providerZhihuApi(OkHttpClient client){
        return new ZhihuApiOkHttpImpl(client);
    }

    @Provides
    @Singleton
    public OkHttpClient providerOkHttpClient(){
        return OkHttpUtil.newOkHttpClient();
    }

    @Provides
    public IZhihuRetorfitApi providerIZhihuRetorfitApi(OkHttpClient client){
        return RetrofitUtil.createApi(IZhihuRetorfitApi.class, client);
    }
}
