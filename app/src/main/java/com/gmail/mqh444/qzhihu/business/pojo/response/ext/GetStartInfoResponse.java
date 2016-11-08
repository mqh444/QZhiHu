package com.gmail.mqh444.qzhihu.business.pojo.response.ext;

import com.gmail.mqh444.qzhihu.business.pojo.response.BaseResponse;
import com.google.gson.annotations.SerializedName;

/**
 * GetStartInfoResponse
 * Created by Louis on 2016/11/8.
 */

public class GetStartInfoResponse extends BaseResponse {

    @SerializedName("text")
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @SerializedName("img")
    private String img;

    @Override
    public String toString() {
        return "StartInfoResponse{" +
                "text='" + text + '\'' +
                ", img='" + img + '\'' +
                "} " + super.toString();
    }
}
