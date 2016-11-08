package com.gmail.mqh444.qzhihu.business.pojo.request.ext;

import com.gmail.mqh444.qzhihu.business.pojo.request.BaseRequest;

/**
 * GetStartInfoRequest
 * Created by Louis on 2016/11/8.
 */

public class GetStartInfoRequest extends BaseRequest {

    public int width;

    public int height;

    public GetStartInfoRequest(int width,int height){
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "GetStartInfoRequest{" +
                "width=" + width +
                ", height=" + height +
                "} " + super.toString();
    }
}
