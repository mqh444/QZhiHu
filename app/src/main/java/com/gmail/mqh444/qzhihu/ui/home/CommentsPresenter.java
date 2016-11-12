package com.gmail.mqh444.qzhihu.ui.home;

import com.gmail.mqh444.qzhihu.app.InjectHelp;
import com.gmail.mqh444.qzhihu.business.domain.ZhihuDomain;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetLongCommentsResponse;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetShortCommentsResponse;
import com.gmail.mqh444.qzhihu.ui.base.mvp.BaseMvpPresenter;
import com.gmail.mqh444.qzhihu.ui.base.mvp.ILoadDataView;
import com.gmail.mqh444.qzhihu.ui.base.mvp.IMvpView;

import javax.inject.Inject;

import rx.Observable;

/**
 * CommentsPresenter
 * Created by Louis on 2016/11/12.
 */

public class CommentsPresenter extends BaseMvpPresenter<CommentsPresenter.ICommentsView> {

    @Inject
    ZhihuDomain zhihuDomain;

    private boolean isLoadShort = false;

    @Override
    public void create(ILoadDataView loadDataView, ICommentsView view) {
        super.create(loadDataView, view);

        InjectHelp.appComponent().inject(this);
    }

    public Observable<GetShortCommentsResponse> doGetShortComments(int id){
        isLoadShort = true;
        return zhihuDomain.getShortCommentsById(id);
    }

    public Observable<GetLongCommentsResponse> doGetLongCommentsById(int id){
        return zhihuDomain.getLongCommentsById(id);
    }

    public boolean isLoadShort(){
        return isLoadShort;
    }

    public interface ICommentsView extends IMvpView {

    }
}
