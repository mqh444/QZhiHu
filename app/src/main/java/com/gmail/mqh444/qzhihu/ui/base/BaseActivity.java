package com.gmail.mqh444.qzhihu.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.gmail.mqh444.qzhihu.ui.base.mvp.ILoadDataView;
import butterknife.ButterKnife;

/**
 * BaseActivity
 * Created by Louis on 2016/11/11.
 */

public abstract class BaseActivity extends AppCompatActivity implements ILoadDataView {

    static final String LOADING_DIALOG_TAG = "loading_dialog";

    private DialogFragment loadingDialogFragment;
    protected Handler uiHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initActionBar();
        uiHandler = new Handler(getMainLooper());
    }

    protected abstract int getLayoutId();

    // ************ ActionBar *************
    private void initActionBar(){
        if (getSupportActionBar() != null){
            int options = ActionBar.DISPLAY_HOME_AS_UP
                    | ActionBar.DISPLAY_USE_LOGO
                    | ActionBar.DISPLAY_SHOW_TITLE;
            getSupportActionBar().setDisplayOptions(options);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    public void setTitle(int titleId){
        setTitle(getString(titleId));
    }

    public void setTitle(CharSequence title){
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }

    // ********* ILoadDataView *************

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showLoading() {
        showLoading(LOADING_TYPE_DEFAULT);
    }

    @Override
    public final void showLoading(int loadingType) {
        switch (loadingType){
            case LOADING_TYPE_DEFAULT:
            default:
                showDefaultStyleLoadingDialog(null);
                break;
        }
    }

    // 显示用默认样式的Loading对话框
    private void showDefaultStyleLoadingDialog(String loadingTitle){
        hideDefaultStyleLoadingDialog();

        DialogFragment newFragment = LoadingDialogFragment.newInstance(loadingTitle);
        newFragment.show(getSupportFragmentManager(), LOADING_DIALOG_TAG);
        loadingDialogFragment = newFragment;
    }

    @Override
    public void hideLoading() {
        hideLoading(LOADING_TYPE_DEFAULT);
    }

    @Override
    public final void hideLoading(int loadingType) {
        switch (loadingType){
            case LOADING_TYPE_DEFAULT:
            default:
                hideDefaultStyleLoadingDialog();
                break;
        }
    }

    // 隐藏默认样式的loading对话框
    private void hideDefaultStyleLoadingDialog() {
        if (loadingDialogFragment != null){
            loadingDialogFragment.dismiss();
            loadingDialogFragment = null;
        }
    }

    @Override
    public void showError(String message) {
        Toast.makeText(BaseActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
