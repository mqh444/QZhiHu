package com.gmail.mqh444.qzhihu.business.pojo.request.ext;

import com.gmail.mqh444.qzhihu.business.pojo.request.BaseRequest;
import com.google.gson.annotations.SerializedName;

/**
 * GetStoryExtraRequest
 * Created by Louis on 2016/11/8.
 */

public class GetStoryExtraRequest extends BaseRequest {

    @SerializedName("id")
    public int id;

    public GetStoryExtraRequest(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "GetStoryExtraRequest{" +
                "id=" + id +
                "} " + super.toString();
    }
}
