package com.gmail.mqh444.qzhihu.business.pojo.response.ext;

import com.gmail.mqh444.qzhihu.business.pojo.bean.LastThemeTopStory;
import com.gmail.mqh444.qzhihu.business.pojo.bean.LastThemeStory;
import com.gmail.mqh444.qzhihu.business.pojo.response.BaseResponse;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * GetLastThemeResponse
 * Created by Louis on 2016/11/8.
 */

public class GetLastThemeResponse extends BaseResponse {

    @SerializedName("date")
    private String date;

    @SerializedName("stories")
    private LastThemeStory[] stories;

    @SerializedName("top_stories")
    private LastThemeTopStory[] topStories;

    @Override
    public String toString() {
        return "GetLastThemeResponse{" +
                "date='" + date + '\'' +
                ", stories=" + Arrays.toString(stories) +
                ", top_stories=" + Arrays.toString(topStories) +
                "} " + super.toString();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public LastThemeStory[] getStories() {
        return stories;
    }

    public void setStories(LastThemeStory[] stories) {
        this.stories = stories;
    }

    public LastThemeTopStory[] getTopStories() {
        return topStories;
    }

    public void setTopStories(LastThemeTopStory[] topStories) {
        this.topStories = topStories;
    }

}
