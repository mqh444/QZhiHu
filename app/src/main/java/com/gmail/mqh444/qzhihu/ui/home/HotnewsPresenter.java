package com.gmail.mqh444.qzhihu.ui.home;

import com.gmail.mqh444.qzhihu.app.InjectHelp;
import com.gmail.mqh444.qzhihu.business.domain.ZhihuDomain;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetLastThemeResponse;
import com.gmail.mqh444.qzhihu.ui.base.mvp.BaseMvpPresenter;
import com.gmail.mqh444.qzhihu.ui.base.mvp.ILoadDataView;
import com.gmail.mqh444.qzhihu.ui.base.mvp.IMvpView;

import javax.inject.Inject;

import rx.Observable;

/**
 * HotnewsPresenter
 * Created by Louis on 2016/11/13.
 */

public class HotnewsPresenter extends BaseMvpPresenter<HotnewsPresenter.IHotnewsView> {

    @Inject
    ZhihuDomain zhihuDomain;

    @Override
    public void create(ILoadDataView loadDataView, IHotnewsView view) {
        super.create(loadDataView, view);

        InjectHelp.appComponent().inject(this);
    }

    public Observable<GetLastThemeResponse> doGetLastTheme(){
        return zhihuDomain.getLastTheme();
    }

    public interface IHotnewsView extends IMvpView{

    }
}
