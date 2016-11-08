package com.gmail.mqh444.qzhihu.business.pojo.request.ext;

import com.gmail.mqh444.qzhihu.business.pojo.request.BaseRequest;

/**
 * GetThemeRequest
 * Created by Louis on 2016/11/8.
 */

public class GetThemeRequest extends BaseRequest {

    public int id;

    public GetThemeRequest(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "GetThemeRequest{" +
                "id=" + id +
                "} " + super.toString();
    }
}
