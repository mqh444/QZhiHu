package com.gmail.mqh444.qzhihu.business.pojo.response.ext;

import com.gmail.mqh444.qzhihu.business.pojo.bean.Comment;
import com.gmail.mqh444.qzhihu.business.pojo.response.BaseResponse;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * GetLongCommentsResponse
 * Created by Louis on 2016/11/8.
 */

public class GetLongCommentsResponse extends BaseResponse {

    @SerializedName("comments")
    private Comment[] comments;

    public Comment[] getComments() {
        return comments;
    }

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "GetLongCommentsResponse{" +
                "comments=" + Arrays.toString(comments) +
                "} " + super.toString();
    }
}
