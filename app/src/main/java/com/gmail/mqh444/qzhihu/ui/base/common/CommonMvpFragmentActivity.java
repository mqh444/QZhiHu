package com.gmail.mqh444.qzhihu.ui.base.common;

import android.os.Bundle;

import com.gmail.mqh444.qzhihu.R;
import com.gmail.mqh444.qzhihu.ui.base.mvp.MvpActivity;

/**
 * CommonMvpFragmentActivity
 * Created by Louis on 2016/11/12.
 */

public class CommonMvpFragmentActivity extends MvpActivity {

    private ActivityDelegate<CommonMvpFragmentActivity, CommonMvpFragment> delegate;

    protected void onCreate(Bundle savedInstanceState){
        if (delegate == null){
            delegate = getDeledate();
        }

        delegate.beforeOnCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        delegate.afterOnCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.act_common_fm;
    }

    protected ActivityDelegate<CommonMvpFragmentActivity, CommonMvpFragment> getDeledate(){
        return new ActivityDelegate(this);
    }

    protected final CommonExtraParam getExtraParam(){
        return delegate.getExtraParam();
    }

    protected CommonMvpFragment getCommonFragment(){
        return delegate.getCommonFragment();
    }

    public void onBackPressed(){
        if (getCommonFragment() != null) {
            if (getCommonFragment().onActivityPressBack()) {
                super.onBackPressed();
            }
        }else {
            super.onBackPressed();
        }
    }

    public boolean onSupportNavigateUp(){
        return getCommonFragment() != null
                && getCommonFragment().onActivitySupportNavigateUp()
                || super.onSupportNavigateUp();
    }
}
