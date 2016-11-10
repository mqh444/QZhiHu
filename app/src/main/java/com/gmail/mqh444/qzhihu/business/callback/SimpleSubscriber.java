package com.gmail.mqh444.qzhihu.business.callback;

import com.gmail.mqh444.qzhihu.business.pojo.response.BaseResponse;
import com.gmail.mqh444.qzhihu.core.log.XLog;

import rx.Subscriber;

/**
 * SimpleSubscriber
 * Created by Louis on 2016/11/10.
 */

public class SimpleSubscriber<T extends BaseResponse> extends Subscriber<T> {

    private boolean isSuccess = false; // 是否成功

    private T response; // 得到的数据结果

    @Override
    public void onStart() {
        super.onStart();
        XLog.d(this + "....onStart");
    }

    @Override
    public final void onNext(T response) {
        XLog.d(this + "....onNext");

        if (response == null){
            XLog.e("response is null.");
            return;
        }
        if (response.isSuccess()){
            isSuccess = true;
            onHandleSuccess(response);
        }else{
            onHandleFail(response.getErrorMsg(),null);
        }
    }

    @Override
    public final void onError(Throwable throwable) {
        XLog.d(this + "....onError");
        onHandleFail(null, throwable);

        onHandleFinish();
    }

    @Override
    public final void onCompleted() {
        XLog.d(this + "....onCompleted");

        onHandleFinish();
    }

    /**
     * 处理成功
     * @param response
     */
    public void onHandleSuccess(T response) {
        XLog.d("response = " + response);
    }

    /**
     * 处理失败
     * @param message
     */
    public void onHandleFail(String message, Throwable throwable) {
        XLog.d(this + "....onHandleFail");
        XLog.e("message = %s , throwable = %s", message, throwable);
    }

    /**
     * 处理结束
     */
    public void onHandleFinish() {
        XLog.d(this + "....onHandleFinish");
    }

    public T getResponse(){
        return response;
    }

    public boolean isSuccess(){
        return isSuccess;
    }
}
