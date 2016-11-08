package com.gmail.mqh444.qzhihu.business.pojo.request.ext;

import com.gmail.mqh444.qzhihu.business.pojo.request.BaseRequest;

/**
 * GetNewsRequest
 * Created by Louis on 2016/11/8.
 */

public class GetNewsRequest extends BaseRequest {

    public int id;

    public GetNewsRequest(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "GetNewsRequest{" +
                "id=" + id +
                "} " + super.toString();
    }
}
