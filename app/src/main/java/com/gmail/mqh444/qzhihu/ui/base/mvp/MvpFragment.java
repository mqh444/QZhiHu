package com.gmail.mqh444.qzhihu.ui.base.mvp;

import com.gmail.mqh444.qzhihu.ui.base.BaseFragment;

/**
 * MvpFragment
 * Created by Louis on 2016/11/11.
 */

public abstract class MvpFragment<P extends BaseMvpPresenter<V>, V extends IMvpView> extends BaseFragment {

    protected MvpActivity mvpActivity;
}
