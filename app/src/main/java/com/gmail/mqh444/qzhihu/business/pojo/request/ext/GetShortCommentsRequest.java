package com.gmail.mqh444.qzhihu.business.pojo.request.ext;

import com.gmail.mqh444.qzhihu.business.pojo.request.BaseRequest;

/**
 * GetShortCommentsRequest
 * Created by Louis on 2016/11/8.
 */

public class GetShortCommentsRequest extends BaseRequest {

    public int id;

    public GetShortCommentsRequest(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "GetShortCommentsRequest{" +
                "id=" + id +
                "} " + super.toString();
    }
}
