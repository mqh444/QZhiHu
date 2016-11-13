package com.gmail.mqh444.qzhihu.ui.home;

import com.gmail.mqh444.qzhihu.app.InjectHelp;
import com.gmail.mqh444.qzhihu.business.domain.ZhihuDomain;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetNewsResponse;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetStoryExtraResponse;
import com.gmail.mqh444.qzhihu.ui.base.mvp.BaseMvpPresenter;
import com.gmail.mqh444.qzhihu.ui.base.mvp.ILoadDataView;
import com.gmail.mqh444.qzhihu.ui.base.mvp.IMvpView;

import javax.inject.Inject;

import rx.Observable;

/**
 * DetailPresenter
 * Created by Louis on 2016/11/13.
 */

public class DetailPresenter extends BaseMvpPresenter<DetailPresenter.IDetailView> {

    @Inject
    ZhihuDomain domain;

    @Override
    public void create(ILoadDataView loadDataView, IDetailView view){
        super.create(loadDataView, view);

        InjectHelp.appComponent().inject(this);
    }

    Observable<GetNewsResponse> doGetNewsResponse(int id){
        return domain.getNewsById(id);
    }

    Observable<GetStoryExtraResponse> doGetStoryExtra(int id){
        return domain.getStoryExtraById(id);
    }

    public interface IDetailView extends IMvpView {

    }
}
