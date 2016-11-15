package com.gmail.mqh444.qzhihu.ui;

import com.gmail.mqh444.qzhihu.app.InjectHelp;
import com.gmail.mqh444.qzhihu.business.domain.ZhihuDomain;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetStartInfoResponse;
import com.gmail.mqh444.qzhihu.ui.base.mvp.BaseMvpPresenter;
import com.gmail.mqh444.qzhihu.ui.base.mvp.ILoadDataView;
import com.gmail.mqh444.qzhihu.ui.base.mvp.IMvpView;

import javax.inject.Inject;

import rx.Observable;

/**
 * StartPresenter
 * Created by Louis on 2016/11/15.
 */

public class StartPresenter extends BaseMvpPresenter<StartPresenter.IStartView> {

    @Inject
    ZhihuDomain zhihuDomain;

    @Override
    public void create(ILoadDataView loadDataView, IStartView view){
        super.create(loadDataView, view);

        InjectHelp.appComponent().inject(this);
    }

    public Observable<GetStartInfoResponse> doGetStartInfo(){
        return zhihuDomain.getStartInfo(1080, 1776);
    }

    public interface IStartView extends IMvpView{

    }
}
