package com.gmail.mqh444.qzhihu.app;

import com.gmail.mqh444.qzhihu.ui.StartPresenter;
import com.gmail.mqh444.qzhihu.ui.home.CommentsPresenter;
import com.gmail.mqh444.qzhihu.ui.home.DetailPresenter;
import com.gmail.mqh444.qzhihu.ui.home.HotnewsPresenter;
import com.gmail.mqh444.qzhihu.ui.MainPresenter;
import com.gmail.mqh444.qzhihu.ui.home.OtherThemePresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * AppComponent
 * Created by Louis on 2016/11/7.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(CommentsPresenter presenter);

    void inject(DetailPresenter presenter);

    void inject(HotnewsPresenter presenter);

    void inject(OtherThemePresenter presenter);

    void inject(MainPresenter presenter);

    void inject(StartPresenter presenter);
}
