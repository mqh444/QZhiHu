package com.gmail.mqh444.qzhihu.ui.base.common;

import com.gmail.mqh444.qzhihu.ui.base.mvp.BaseMvpPresenter;
import com.gmail.mqh444.qzhihu.ui.base.mvp.IMvpView;

/**
 * Created by Louis on 2016/11/11.
 */

public abstract class CommonMvpFragment<P extends BaseMvpPresenter<V>, V extends IMvpView>
        extends MvpFragment<P, V> implements ICommonFragment {
}
