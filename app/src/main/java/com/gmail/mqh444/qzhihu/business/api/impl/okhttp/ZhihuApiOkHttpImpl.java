package com.gmail.mqh444.qzhihu.business.api.impl.okhttp;

import com.gmail.mqh444.qzhihu.business.api.ZhihuApi;
import com.gmail.mqh444.qzhihu.business.api.impl.OkHttpUtil;
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
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * ZhihuApiOkHttpImpl
 * Created by Louis on 2016/11/9.
 */

public class ZhihuApiOkHttpImpl implements ZhihuApi {

    private static final String MSG = "req = %s, resp = %s";

    private OkHttpClient okHttpClient;

    private Gson gson;

    public ZhihuApiOkHttpImpl(OkHttpClient client){
        okHttpClient = client;
        gson = new Gson();
    }

    @Override
    public GetStartInfoResponse getStartInfoResponse(GetStartInfoRequest request) throws NetWorkException {
        XLog.d("ZhihuApiOkHttpImpl.getStartInfoResponse request = " + request);

        // 1.启动界面图片
        String url = "http://news-at.zhihu.com/api/4/start-image/%d*%d";
        url = String.format(url, request.width,request.height);
        GetStartInfoResponse response = call(url, GetStartInfoResponse.class);

        XLog.i(MSG, request,response);
        return response;
    }

    @Override
    public GetAllThemesResponse getAllThemesResponse(GetAllThemesRequest request) throws NetWorkException {
        XLog.d("ZhihuApiOkHttpImpl.getAllThemesResponse request = " + request);

        // 9.主题日报列表查看
        String url = "http://news-at.zhihu.com/api/4/themes";
        GetAllThemesResponse response = call(url, GetAllThemesResponse.class);

        XLog.i(MSG, request, response);

        return response;
    }

    @Override
    public GetLastThemeResponse getLastThemeResponse(GetLastThemeRequest request) throws NetWorkException {
        XLog.d("ZhihuApiOkHttpImpl.getLastThemeResponse request = " + request);

        // 3.最新消息
        String url = "http://news-at.zhihu.com/api/4/news/latest";
        GetLastThemeResponse response = call(url, GetLastThemeResponse.class);

        XLog.i(MSG, request, response);

        return response;
    }

    @Override
    public GetNewsResponse getNewsResponse(GetNewsRequest request) throws NetWorkException {
        XLog.d("ZhihuApiOkHttpImpl.getNewsResponse request = " + request);

        // 4.消息内容获取与离线下载
        String url = "http://news-at.zhihu.com/api/4/news/%s";
        url = String.format(url, request.id);
        GetNewsResponse response = call(url, GetNewsResponse.class);

        XLog.i(MSG, request, response);

        return response;
    }

    @Override
    public GetThemeResponse getThemeResponse(GetThemeRequest request) throws NetWorkException {
        XLog.d("ZhihuApiOkHttpImpl.getThemeResponse request = " + request);

        // 10.主题日报内容查看
        String url = "http://news-at.zhihu.com/api/4/theme/%s";
        url = String.format(url, request.id);
        GetThemeResponse response = call(url, GetThemeResponse.class);

        XLog.i(MSG, request, response);

        return response;
    }

    @Override
    public GetStoryExtraResponse getStoryExtraResponse(GetStoryExtraRequest request) throws NetWorkException {
        XLog.d("ZhihuApiOkHttpImpl.getStoryExtraResponse request = " + request);

        // 6. 新闻额外信息
        String url = "http://news-at.zhihu.com/api/4/story-extra/%s";
        url = String.format(url, request.id);
        GetStoryExtraResponse response = call(url, GetStoryExtraResponse.class);

        XLog.i(MSG, request, response);

        return response;
    }

    @Override
    public GetShortCommentsResponse getShortCommentsResponse(GetShortCommentsRequest request) throws NetWorkException {
        XLog.d("ZhihuApiOkHttpImpl.getShortComments request = " + request);

        // 8. 新闻对应短评论查看
        String url = "http://news-at.zhihu.com/api/4/story/%s/short-comments";
        url = String.format(url, request.id);
        GetShortCommentsResponse response = call(url, GetShortCommentsResponse.class);

        XLog.i(MSG, request, response);

        return response;
    }

    @Override
    public GetLongCommentsResponse getLongCommentsResponse(GetLongCommentsRequest request) throws NetWorkException {
        XLog.d("ZhihuApiOkHttpImpl.getLongComments request = " + request);

        // 7. 新闻对应长评论查看
        String url = "http://news-at.zhihu.com/api/4/story/%s/long-comments";
        url = String.format(url, request.id);
        GetLongCommentsResponse response = call(url, GetLongCommentsResponse.class);

        XLog.i(MSG, request, response);

        return response;
    }

    <T> T call(String url, Class<T> tClass) throws NetWorkException {
        XLog.i("ZhihuApiOkHttpImpl.call url = " + url);
        Request request = new Request.Builder()
                .url(url)
                .get()
                .cacheControl(OkHttpUtil.getCacheControl())
                .build();

        T t = null;
        try {
            Response response = okHttpClient.newCall(request).execute();
            XLog.i("response = " + response);
            if (response != null && response.isSuccessful()){
                String body = response.body().string();
                t = gson.fromJson(body, tClass);
            }
        }catch (IOException e){
            XLog.e("ZhihuApiOkHttpImpl.call e = " + e, e);
            throw new NetWorkException(e);
        }
        return t;
    }
}
