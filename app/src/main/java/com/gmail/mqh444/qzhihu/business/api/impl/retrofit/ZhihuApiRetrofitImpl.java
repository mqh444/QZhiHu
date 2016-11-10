package com.gmail.mqh444.qzhihu.business.api.impl.retrofit;

import com.gmail.mqh444.qzhihu.business.api.ZhihuApi;
import com.gmail.mqh444.qzhihu.business.pojo.request.ext.GetAllThemesRequest;
import com.gmail.mqh444.qzhihu.business.pojo.request.ext.GetLastThemeRequest;
import com.gmail.mqh444.qzhihu.business.pojo.request.ext.GetLongCommentsRequest;
import com.gmail.mqh444.qzhihu.business.pojo.request.ext.GetNewsRequest;
import com.gmail.mqh444.qzhihu.business.pojo.request.ext.GetShortCommentsRequest;
import com.gmail.mqh444.qzhihu.business.pojo.request.ext.GetStartInfoRequest;
import com.gmail.mqh444.qzhihu.business.pojo.request.ext.GetStoryExtraRequest;
import com.gmail.mqh444.qzhihu.business.pojo.request.ext.GetThemeRequest;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetAllThemesResponse;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetLastThemeResponse;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetLongCommentsResponse;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetNewsResponse;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetShortCommentsResponse;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetStartInfoResponse;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetStoryExtraResponse;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetThemeResponse;
import com.gmail.mqh444.qzhihu.core.log.XLog;
import com.gmail.mqh444.qzhihu.core.net.NetWorkException;

/**
 * ZhihuApiRetrofitImpl
 * Created by Louis on 2016/11/10.
 */

public class ZhihuApiRetrofitImpl implements ZhihuApi {

    private IZhihuRetorfitApi httpApi;

    public ZhihuApiRetrofitImpl(IZhihuRetorfitApi httpApi) {
        this.httpApi = httpApi;
    }

    @Override
    public GetStartInfoResponse getStartInfoResponse(final GetStartInfoRequest request) throws NetWorkException {
        XLog.i("ZhihuApiRetrofitImpl.getStartInfoResponse request = " + request);

        return new RetrofitAdapter<GetStartInfoResponse>(){
            @Override
            GetStartInfoResponse call() throws Exception {
                return httpApi.getStartInfoResponse(request.width, request.height).execute().body();
            }
        }.get();
    }

    @Override
    public GetAllThemesResponse getAllThemesResponse(GetAllThemesRequest request) throws NetWorkException {
        XLog.i("ZhihuApiRetrofitImpl.getAllThemesResponse request = " + request);

        return new RetrofitAdapter<GetAllThemesResponse>(){
            @Override
            GetAllThemesResponse call() throws Exception {
                return httpApi.getAllThemesResponse().execute().body();
            }
        }.get();
    }

    @Override
    public GetLastThemeResponse getLastThemeResponse(GetLastThemeRequest request) throws NetWorkException {
        XLog.i("ZhihuApiRetrofitImpl.getLastThemeResponse request = " + request);

        return new RetrofitAdapter<GetLastThemeResponse>(){
            @Override
            GetLastThemeResponse call() throws Exception {
                return httpApi.getLastThemeResponse().execute().body();
            }
        }.get();
    }

    @Override
    public GetNewsResponse getNewsResponse(final GetNewsRequest request) throws NetWorkException {
        XLog.i("ZhihuApiRetrofitImpl.getNewsResponse request = " + request);

        return new RetrofitAdapter<GetNewsResponse>(){
            @Override
            GetNewsResponse call() throws Exception {
                return httpApi.getNewsResponse(request.id).execute().body();
            }
        }.get();
    }

    @Override
    public GetThemeResponse getThemeResponse(final GetThemeRequest request) throws NetWorkException {
        XLog.i("ZhihuApiRetrofitImpl.getThemeResponse request = " + request);

        return new RetrofitAdapter<GetThemeResponse>(){
            @Override
            GetThemeResponse call() throws Exception {
                return httpApi.getThemeResponse(request.id).execute().body();
            }
        }.get();
    }

    @Override
    public GetStoryExtraResponse getStoryExtraResponse(final GetStoryExtraRequest request) throws NetWorkException {
        XLog.i("ZhihuApiRetrofitImpl.getStoryExtraResponse request = " + request);

        return new RetrofitAdapter<GetStoryExtraResponse>(){
            @Override
            GetStoryExtraResponse call() throws Exception {
                return httpApi.getStoryExtraResponse(request.id).execute().body();
            }
        }.get();
    }

    @Override
    public GetShortCommentsResponse getShortCommentsResponse(final GetShortCommentsRequest request) throws NetWorkException {
        XLog.i("ZhihuApiRetrofitImpl.getShortComments request = " + request);

        return new RetrofitAdapter<GetShortCommentsResponse>(){
            @Override
            GetShortCommentsResponse call() throws Exception {
                return httpApi.getShortComments(request.id).execute().body();
            }
        }.get();
    }

    @Override
    public GetLongCommentsResponse getLongCommentsResponse(final GetLongCommentsRequest request) throws NetWorkException {
        XLog.i("ZhihuApiRetrofitImpl.GetStartInfoResponse request = " + request);

        return new RetrofitAdapter<GetLongCommentsResponse>(){
            @Override
            GetLongCommentsResponse call() throws Exception {
                return httpApi.getLongComments(request.id).execute().body();
            }
        }.get();
    }
}
