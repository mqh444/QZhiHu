package com.gmail.mqh444.qzhihu.business.pojo.response.ext;

import com.gmail.mqh444.qzhihu.business.pojo.bean.Comment;
import com.gmail.mqh444.qzhihu.business.pojo.response.BaseResponse;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * GetShortCommentsResponse
 * Created by Louis on 2016/11/8.
 */

public class GetShortCommentsResponse extends BaseResponse {

    public Comment[] getComments() {
        return comments;
    }

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }

    @SerializedName("comments")
    private Comment[] comments;

    @Override
    public String toString() {
        return "GetShortCommentsResponse{" +
                "comments=" + Arrays.toString(comments) +
                "} " + super.toString();
    }
}
