package com.gmail.mqh444.qzhihu.business.domain;

import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetAllThemesResponse;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetLastThemeResponse;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetLongCommentsResponse;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetNewsResponse;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetShortCommentsResponse;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetStartInfoResponse;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetStoryExtraResponse;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetThemeResponse;

import rx.Observable;


/**
 * ZhihuDomain
 * Created by Louis on 2016/11/8.
 */

public interface ZhihuDomain {

    Observable<GetStartInfoResponse> getStartInfo(int width, int height);

    Observable<GetAllThemesResponse> getAllThemes();

    Observable<GetLastThemeResponse> getLastTheme();

    Observable<GetNewsResponse> getNewsById(int id);

    Observable<GetThemeResponse> getThemeById(int id);

    Observable<GetStoryExtraResponse> getStoryExtraById(int id);

    Observable<GetShortCommentsResponse> getShortCommentsById(int id);

    Observable<GetLongCommentsResponse> getLongCommentsById(int id);
}
