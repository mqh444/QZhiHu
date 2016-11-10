package com.gmail.mqh444.qzhihu.business.callback;

import android.text.TextUtils;

import com.gmail.mqh444.qzhihu.R;
import com.gmail.mqh444.qzhihu.app.InjectHelp;
import com.gmail.mqh444.qzhihu.business.pojo.response.BaseResponse;
import com.gmail.mqh444.qzhihu.core.log.XLog;
import com.gmail.mqh444.qzhihu.core.net.NetWorkException;
import com.gmail.mqh444.qzhihu.ui.base.mvp.ILoadDataView;
import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.io.InterruptedIOException;
import java.lang.ref.SoftReference;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

/**
 * 业务层建议使用这个，可以抓取到日志
 * AdvancedSubscriber
 * Created by Louis on 2016/11/10.
 */

public class AdvancedSubscriber<T extends BaseResponse> extends SimpleSubscriber<T> {

    private SoftReference<ILoadDataView> loadDataViewSoftReference;

    public AdvancedSubscriber(){
        this(null);
    }

    public AdvancedSubscriber(ILoadDataView loadDataView){
        if (loadDataView != null){
            this.loadDataViewSoftReference = new SoftReference<>(loadDataView);
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        if (checkLoadDataView()){
            loadDataViewSoftReference.get().showLoading();
        }
    }

    @Override
    public void onHandleSuccess(T response) {
        XLog.i("response = " + response);
    }

    @Override
    public void onHandleFail(String message, Throwable throwable) {
        super.onHandleFail(message, throwable);

        if (message != null){ // 业务异常
            doHandleBusinessFail(message);
        }else if (throwable != null) { // 运行异常
            doHandleException(throwable);
        }else{  // 未知异常
            XLog.i("AdvancedSubscriber.onHandleFail message = null, e = null");
        }
    }

    private void doHandleBusinessFail(String msg) {
        XLog.d(this + "....doHandleBusinessFail");
        if (TextUtils.isEmpty(msg)){
            showToast("未知错误");
        }else{
            showToast(msg);
        }
    }

    private void doHandleException(Throwable throwable){
        XLog.d(this + "....doHandleException");
        if (throwable != null){
            XLog.e("AdvancedSubscriber.doHandleException throwable = " + throwable.getMessage(), throwable);
        }

        String toastText = null;
        if (throwable instanceof NetWorkException){
            NetWorkException netWorkException = (NetWorkException) throwable;
            Throwable detailException = netWorkException.getDetailThrowable();
            if (detailException instanceof ConnectException){
                toastText = "Connect Fail";
            }else if (detailException instanceof UnknownHostException){
                toastText = "Unknown Host";
            }else if (detailException instanceof TimeoutException || detailException instanceof InterruptedIOException){
                toastText = "Time Out";
            }else if (detailException instanceof JSONException){
                toastText = "JSON error";
            }else if (detailException instanceof JsonParseException){
                toastText = "Gson parse error";
            }
        }
        if (TextUtils.isEmpty(toastText)){
            showToast(R.string.network_disable);
        }else {
            showToast("[" + toastText + "]");
        }
    }

    protected void showToast(int msg) {
        showToast(InjectHelp.getAppContext().getString(msg));
    }

    protected void showToast(String msg){
        XLog.d("showToast = " + msg);

        if (checkLoadDataView()){
            loadDataViewSoftReference.get().showError(msg);
        }
    }

    @Override
    public void onHandleFinish() {
        super.onHandleFinish();

        if (checkLoadDataView()){
            loadDataViewSoftReference.get().hideLoading();
            loadDataViewSoftReference.clear();
            loadDataViewSoftReference = null;
        }
    }

    boolean checkLoadDataView() {
        return loadDataViewSoftReference != null && loadDataViewSoftReference.get() != null;
    }
}
