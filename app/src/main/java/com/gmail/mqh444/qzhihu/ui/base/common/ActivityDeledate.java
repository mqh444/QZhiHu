package com.gmail.mqh444.qzhihu.ui.base.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.gmail.mqh444.qzhihu.R;
import com.gmail.mqh444.qzhihu.core.log.XLog;

import java.security.InvalidParameterException;

/**
 * ActivityDeledate
 * Created by Louis on 2016/11/10.
 */

public class ActivityDeledate <A extends AppCompatActivity, F extends Fragment> {

    private static final int FRAGMENT_CONTAINER = R.id.fmFragmentContainer;

    private A activity;
    private F commonFragment;
    private CommonExtraParam extraParam;

    public ActivityDeledate(A activity) {
        if (activity == null){
            throw new InvalidParameterException("activity is null.");
        }
        this.activity = activity;
    }

    public void beforeOnCreate(Bundle savedInstanceState){
        XLog.d("beforeOnCreate");
    }

    public void afterOnCreate(Bundle savedInstanceState){
        XLog.d("afterOnCreate");

        init(savedInstanceState);
    }

    private void init(Bundle savedInstanceState) {
        Intent it = activity.getIntent();
        Object obj = it.getSerializableExtra(ICommonFragment.EXTRA_REQ);
        if (validate(obj)){
            extraParam = (CommonExtraParam) obj;
            if (savedInstanceState == null){
                try {
                    commonFragment = (F) extraParam.getFragmentClass().newInstance();
                    FragmentManager manager = activity.getSupportFragmentManager();
                    manager.beginTransaction().add(FRAGMENT_CONTAINER,commonFragment)
                            .commitAllowingStateLoss();
                }catch (InstantiationException e){
                    e.printStackTrace();
                }catch (IllegalAccessException e){
                    e.printStackTrace();
                }
            }
        }else {
            XLog.e(getClass().getSimpleName() + "参数不合法");
            activity.finish();
        }
        XLog.d(String.format("activity = %s, fragment = %s, param = %s", activity, commonFragment, extraParam));
    }

    private boolean validate(Object obj) {
        boolean ret = false;
        do {
            if (obj == null){
                break;
            }
            if (!(obj instanceof CommonExtraParam)){
                break;
            }
            CommonExtraParam param = (CommonExtraParam) obj;
            if (!param.validate()){
                break;
            }
            ret = true;
        }while (false);
        return ret;
    }

    public F getCommonFragment(){
        return commonFragment;
    }

    public CommonExtraParam getExtraParam(){
        return extraParam;
    }
}
