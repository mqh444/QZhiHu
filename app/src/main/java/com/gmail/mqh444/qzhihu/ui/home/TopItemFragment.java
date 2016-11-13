package com.gmail.mqh444.qzhihu.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.mqh444.qzhihu.business.pojo.bean.LastThemeTopStory;
import com.gmail.mqh444.qzhihu.ui.base.mvp.MvpFragment;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * TopItemFragment
 * Created by Louis on 2016/11/13.
 */

public class TopItemFragment extends MvpFragment {

    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.icon)
    ImageView icon;

    LastThemeTopStory topStory;

    @Override
    protected int getFragmentLayout() {
        return R.layout.item_top_item_fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        if (topStory != null){
            text.setText(topStory.getTitle());
            Picasso.with(icon.getContext())
                    .load(topStory.getImage())
                    .into(icon);
        }

        view.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                DetailF
            }
        });
    }
}
