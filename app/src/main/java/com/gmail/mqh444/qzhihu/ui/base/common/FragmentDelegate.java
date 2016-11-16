package com.gmail.mqh444.qzhihu.ui.base.common;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.gmail.mqh444.qzhihu.core.log.XLog;

import java.security.InvalidParameterException;

/**
 * FragmentDelegate
 * Created by Louis on 2016/11/11.
 */

public class FragmentDelegate<F extends Fragment, P extends CommonExtraParam> {

    protected P extraReqParam;
    private F fragment;

    public FragmentDelegate(F f){
        if (f == null){
            throw new InvalidParameterException("fragment is null.");
        }
        this.fragment = f;
    }

    public void beforeOnViewCreated(View view, Bundle saveInstanceState){
        XLog.i("beforeOnViewCreated");
    }

    public void afterOnViewCreated(View view, Bundle saveInstanceState){
        XLog.i("afterOnViewCreated");

        extraReqParam = CommonExtraParam.getExtraReqParam(fragment.getActivity());

        String content = String.format("fragment = %s, extraReqParam = %s", fragment, extraReqParam);
        XLog.d(content);
    }

    public P getExtraReqParam(){
        return extraReqParam;
    }

    public void setSuccessResult(CommonExtraParam extraParam){
        Intent it = new Intent();
        it.putExtra(ICommonFragment.EXTRA_RESP, extraParam);
        fragment.getActivity().setResult(Activity.RESULT_OK, it);
        fragment.getActivity().finish();
    }
}
