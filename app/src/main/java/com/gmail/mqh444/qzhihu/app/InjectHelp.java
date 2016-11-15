package com.gmail.mqh444.qzhihu.app;

import android.app.Application;

import de.greenrobot.event.EventBus;

/**
 * Created by Louis on 2016/11/7.
 */
public class InjectHelp {

    private static AppComponent appComponent;

    static synchronized void init(Application application){
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }

    public static AppComponent appComponent(){
        return appComponent;
    }

    public static AppContext getAppContext(){
        return AppContext.getInstance();
    }

    public static EventBus getEventBus(){
        return EventBus.getDefault();
    }

    private InjectHelp(){}
}
