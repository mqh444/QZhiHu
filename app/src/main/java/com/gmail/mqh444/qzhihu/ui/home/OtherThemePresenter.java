package com.gmail.mqh444.qzhihu.ui.home;

import com.gmail.mqh444.qzhihu.app.InjectHelp;
import com.gmail.mqh444.qzhihu.business.domain.ZhihuDomain;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetThemeResponse;
import com.gmail.mqh444.qzhihu.ui.base.mvp.BaseMvpPresenter;
import com.gmail.mqh444.qzhihu.ui.base.mvp.ILoadDataView;
import com.gmail.mqh444.qzhihu.ui.base.mvp.IMvpView;

import javax.inject.Inject;

import rx.Observable;

/**
 * OtherThemePresenter
 * Created by Louis on 2016/11/14.
 */

public class OtherThemePresenter extends BaseMvpPresenter<OtherThemePresenter.IHomeView> {

    @Inject
    ZhihuDomain zhihuDomain;

    @Override
    public void create(ILoadDataView loadDataView, IHomeView view) {
        super.create(loadDataView, view);

        InjectHelp.appComponent().inject(this);
    }

    public Observable<GetThemeResponse> doGetThemeById(int id){
        return zhihuDomain.getThemeById(id);
    }

    public interface IHomeView extends IMvpView{
    }
}
