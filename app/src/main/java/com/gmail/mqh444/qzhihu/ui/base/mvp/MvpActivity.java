package com.gmail.mqh444.qzhihu.ui.base.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gmail.mqh444.qzhihu.core.log.XLog;
import com.gmail.mqh444.qzhihu.ui.base.BaseActivity;

/**
 * MvpActivity
 * Created by Louis on 2016/11/11.
 */

public abstract class MvpActivity <P extends BaseMvpPresenter<V>, V extends IMvpView> extends BaseActivity {

    protected P presenter;
    protected V view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        beforeMvpInit(savedInstanceState);

        onMvpInit();

        if (presenter != null){
            // 注册Activity
            presenter.create(this, view);
            presenter.registerEventBusListener(this);
        }
    }

    /**
     * 在初始化mvp前，做些事情
     *
     * @param savedInstanceState
     */
    protected void beforeMvpInit(Bundle savedInstanceState) {
    }

    private void onMvpInit(){
        try{
            initPresenterAndView();
        }catch (Exception e){
            // 防止子类未使用泛型所可能产生的意外错误
            XLog.w("onMvpInit fail, e = " + e);
        }
    }

    /**
     * 通过反射获取{@link P} 和 {@link V}
     */
    protected void initPresenterAndView() {
        MvpHelper<>
    }

}
