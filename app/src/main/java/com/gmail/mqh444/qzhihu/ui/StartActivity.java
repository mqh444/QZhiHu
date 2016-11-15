package com.gmail.mqh444.qzhihu.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.mqh444.qzhihu.R;
import com.gmail.mqh444.qzhihu.business.callback.AdvancedSubscriber;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetStartInfoResponse;
import com.gmail.mqh444.qzhihu.ui.MainActivity;
import com.gmail.mqh444.qzhihu.ui.StartPresenter;
import com.gmail.mqh444.qzhihu.ui.base.mvp.MvpActivity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

/**
 * StartActivity
 * Created by Louis on 2016/11/15.
 */

public class StartActivity extends MvpActivity<StartPresenter, StartPresenter.IStartView>
        implements StartPresenter.IStartView {

    @BindView(R.id.tvText)
    TextView tvText;
    @BindView(R.id.ivImage)
    ImageView ivImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
        gotoNext();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_start;
    }

    private void init() {
        presenter.doGetStartInfo()
                .subscribe(new AdvancedSubscriber<GetStartInfoResponse>(){
                   @Override
                    public void onHandleSuccess(GetStartInfoResponse response){
                       super.onHandleSuccess(response);

                       update(response);
                   }
                });
    }

    private void gotoNext() {
        uiHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getContext(), MainActivity.class));
                finish();
            }
        }, 3000);
    }

    private void update(GetStartInfoResponse response) {
        tvText.setText(response.getText());

        Picasso.with(getContext())
                .load(response.getImg())
                .into(ivImage);
    }
}
