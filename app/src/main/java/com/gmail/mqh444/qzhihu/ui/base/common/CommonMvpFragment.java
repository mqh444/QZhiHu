package com.gmail.mqh444.qzhihu.ui.base.common;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.gmail.mqh444.qzhihu.ui.base.mvp.BaseMvpPresenter;
import com.gmail.mqh444.qzhihu.ui.base.mvp.IMvpView;
import com.gmail.mqh444.qzhihu.ui.base.mvp.MvpFragment;

/**
 * Created by Louis on 2016/11/11.
 */

public abstract class CommonMvpFragment<P extends BaseMvpPresenter<V>, V extends IMvpView>
        extends MvpFragment<P, V> implements ICommonFragment {

    protected Context context;

    private FragmentDelegate<CommonMvpFragment, CommonExtraParam> delegate;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        context = getActivity();

        if (delegate == null){
            delegate = getDelegate();
        }

        delegate.beforeOnViewCreated(view, savedInstanceState);
        super.onViewCreated(view, savedInstanceState);
        delegate.afterOnViewCreated(view, savedInstanceState);

        init(savedInstanceState);
    }

    protected abstract void init(Bundle savedInstanceState);

    protected FragmentDelegate<CommonMvpFragment,CommonExtraParam> getDelegate() {
        return new FragmentDelegate<CommonMvpFragment, CommonExtraParam>(this);
    }

    public final <T extends CommonExtraParam> T getExtraReqParam(){
        return (T) delegate.getExtraReqParam();
    }

    protected final void setSuccessResult(CommonExtraParam extraParam){
        delegate.setSuccessResult(extraParam);
    }

    public boolean onActivityPressBack(){
        return false;
    }

    public boolean onActivitySupportNavigateUp(){
        return false;
    }

}
