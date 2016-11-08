package com.gmail.mqh444.qzhihu.business.pojo.request.ext;

import com.gmail.mqh444.qzhihu.business.pojo.request.BaseRequest;

/**
 * GetLongCommentsRequest
 * Created by Louis on 2016/11/8.
 */

public class GetLongCommentsRequest extends BaseRequest {

    public int id;

    public GetLongCommentsRequest(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "GetLongCommentsRequest{" +
                "id=" + id +
                "} " + super.toString();
    }
}
