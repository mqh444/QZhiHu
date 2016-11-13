package com.gmail.mqh444.qzhihu.ui.home;

import android.os.Bundle;
import android.text.TextUtils;
import android.text.style.UpdateAppearance;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gmail.mqh444.qzhihu.business.callback.AdvancedSubscriber;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetNewsResponse;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetStoryExtraResponse;
import com.gmail.mqh444.qzhihu.ui.base.common.CommonExtraParam;
import com.gmail.mqh444.qzhihu.ui.base.common.CommonMvpFragment;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

/**
 * Created by Louis on 2016/11/13.
 */

public class DetailFragment extends CommonMvpFragment<DetailPresenter, DetailPresenter.IDetailView> {

    public static class DetailExtraParam extends CommonExtraParam {

        public int id;

        @Override
        public String toString() {
            return "DetailExtraParam{" +
                    "id=" + id + '\'' +
                    "} " + super.toString();
        }
    }

    @BindView(R.id.rlDetailTop)
    RelativeLayout rlDetailTop;
    @BindView(R.id.icon)
    ImageView icon;
    @BindView(R.id.webview)
    WebView webView;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvSource)
    TextView tvSource;

    DetailExtraParam extraParam;
    GetStoryExtraResponse storyExtraResponse;

    @Override
    protected void init(Bundle savedInstanceState) {
        extraParam = getExtraReqParam();
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                view.loadUrl(url);
                return true;
            }
        });

        // 启动支持javascript
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName("utf-8");

        setHasOptionsMenu(true);
        doGetRequest();
    }

    private void doGetRequest() {
        presenter.doGetNewsResponse(extraParam.id)
                .subscribe(new AdvancedSubscriber<GetNewsResponse>(mvpActivity){
                @Override
                public void onHandleSuccess(GetNewsResponse response){
                    super.onHandleSuccess(response);

                    update(response);
                }
        });

        presenter.doGetStoryExtra(extraParam.id)
                .subscribe(new AdvancedSubscriber<GetStoryExtraResponse>(){
                    @Override
                    public void onHandleSuccess(GetStoryExtraResponse response) {
                        super.onHandleSuccess(response);
                        storyExtraResponse = response;

                        getActivity().invalidateOptionsMenu();
                        getSupportActionBar().invalidateOptionsMenu();
                    }
                });
    }

    void update(GetNewsResponse response){
        if (response != null){
            tvTitle.setText(response.getTitle());
            tvSource.setText(response.getImageSource());

            if (TextUtils.isEmpty(response.getImage())){
                rlDetailTop.setVisibility(View.GONE);
            }else{
                Picasso.with(icon.getContext())
                        .load(response.getImage())
                        .into(icon);
            }
            webView.loadDataWithBaseURL(null, response.getBody(), "text/html", "utf-8", null);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.detail, menu);
        // TODO: 2016/11/13

        super.onCreateOptionsMenu(menu, inflater);
    }
}
