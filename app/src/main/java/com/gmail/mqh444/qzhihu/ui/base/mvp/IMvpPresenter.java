package com.gmail.mqh444.qzhihu.ui.base.mvp;


/**
 * IMvpPresenter
 * Created by Louis on 2016/11/11.
 */

public interface IMvpPresenter<V extends IMvpView> {

    void create(ILoadDataView loadDataView, V mvpView);

    void destory();
}
