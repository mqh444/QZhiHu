package com.gmail.mqh444.qzhihu.business.api.impl.retrofit;

import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetAllThemesResponse;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetLastThemeResponse;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetLongCommentsResponse;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetNewsResponse;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetShortCommentsResponse;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetStartInfoResponse;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetStoryExtraResponse;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetThemeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * IZhihuApi
 * Created by Louis on 2016/11/10.
 */

public interface IZhihuRetorfitApi {

    @GET("api/4/start-image/{width}*{height}")
    Call<GetStartInfoResponse> getStartInfoResponse(@Path("width") int width, @Path("height") int height);

    @GET("api/4/themes")
    Call<GetAllThemesResponse> getAllThemesResponse();

    @GET("/api/4/news/latest")
    Call<GetLastThemeResponse> getLastThemeResponse();

    @GET("api/4/news/{id}")
    Call<GetNewsResponse> getNewsResponse(@Path("id") int id);

    @GET("api/4/theme/{id}")
    Call<GetThemeResponse> getThemeResponse(@Path("id") int id);

    @GET("api/4/story-extra/{id}")
    Call<GetStoryExtraResponse> getStoryExtraResponse(@Path("id") int id);

    @GET("api/4/story/{id}/short-comments")
    Call<GetShortCommentsResponse> getShortComments(@Path("id") int id);

    @GET("api/4/story/{id}/long-comments")
    Call<GetLongCommentsResponse> getLongComments(@Path("id") int id);
}
