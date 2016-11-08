package com.gmail.mqh444.qzhihu.business.api;

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
import com.gmail.mqh444.qzhihu.core.net.NetWorkException;

/**
 * ZhihuApi
 * Created by Louis on 2016/11/8.
 */

public interface ZhihuApi {

    // 1.启动界面图像获取
    GetStartInfoResponse getStartInfoResponse(GetStartInfoRequest request) throws NetWorkException;

    // 9.主题日报列表查看
    GetAllThemesResponse getAllThemesResponse(GetAllThemesRequest request) throws NetWorkException;

    // 3.最新消息
    GetLastThemeResponse getLastThemeResponse(GetLastThemeRequest request) throws NetWorkException;

    // 4.消息内容获取与离线下载
    GetNewsResponse getNewsResponse(GetNewsRequest request) throws NetWorkException;

    // 10.主题日报内容查看
    GetThemeResponse getThemeResponse(GetThemeRequest request) throws NetWorkException;

    // 6.新闻额外信息
    GetStoryExtraResponse getStoryExtraResponse(GetStoryExtraRequest request) throws NetWorkException;

    // 8.新闻对应短评论查看
    GetShortCommentsResponse getShortCommentsResponse(GetShortCommentsRequest request) throws NetWorkException;

    // 7.新闻对应长评论查看
    GetLongCommentsResponse getLongCommentsResponse(GetLongCommentsRequest request) throws NetWorkException;
}
