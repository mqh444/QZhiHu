package com.gmail.mqh444.qzhihu.business.pojo.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Louis on 2016/11/8.
 */

public class BaseResponse implements IResponse {

    @SerializedName("status")
    private int status;

    @SerializedName("error_msg")
    private String errorMsg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }


    public boolean isSuccess(){
        return status == 0;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "status=" + status +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
