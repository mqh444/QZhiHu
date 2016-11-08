package com.gmail.mqh444.qzhihu.business.pojo.response.ext;

import com.gmail.mqh444.qzhihu.business.pojo.bean.ThemeItem;
import com.gmail.mqh444.qzhihu.business.pojo.response.BaseResponse;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * GetAllThemesResponse
 * Created by Louis on 2016/11/8.
 */

public class GetAllThemesResponse extends BaseResponse {

    @SerializedName("limit")
    private int limit;

    @SerializedName("subscribed")
    private Object[] subscribed;

    @SerializedName("others")
    private ThemeItem[] others;

    @Override
    public String toString() {
        return "GetAllThemesResponse{" +
                "limit=" + limit +
                ", subscribed=" + Arrays.toString(subscribed) +
                ", others=" + Arrays.toString(others) +
                "} " + super.toString();
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Object[] getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(Object[] subscribed) {
        this.subscribed = subscribed;
    }

    public ThemeItem[] getOthers() {
        return others;
    }

    public void setOthers(ThemeItem[] others) {
        this.others = others;
    }

}
