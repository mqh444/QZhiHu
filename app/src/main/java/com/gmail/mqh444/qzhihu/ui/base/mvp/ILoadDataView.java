package com.gmail.mqh444.qzhihu.ui.base.mvp;

/**
 * ILoadDataView
 * Created by Louis on 2016/11/10.
 */

public interface ILoadDataView extends IView {

    /**
     * loading对话框默认类型
     */
    int LOADING_TYPE_DEFAULT = 101;

    /**
     * 使用LOADING_TYPE_DEFAULT显示loading对话框
     */
    void showLoading();

    void showLoading(int loadingType);

    /**
     * 隐藏所有正在显示的loading对话框
     */
    void hideLoading();

    void hideLoading(int loadingType);

    void showError(String message);
}
