package com.gmail.mqh444.qzhihu.app;

import android.app.Application;


/**
 * Created by Louis on 2016/11/7.
 */

public class AppContext extends Application {

    private static AppContext instance;

    protected static AppContext getInstance(){
        return instance;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        instance = this;
        initInject();
    }

    void initInject() {
        InjectHelp.init(this);
    }
}
