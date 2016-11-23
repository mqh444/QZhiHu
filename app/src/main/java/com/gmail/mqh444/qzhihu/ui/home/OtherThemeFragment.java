package com.gmail.mqh444.qzhihu.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.mqh444.qzhihu.R;
import com.gmail.mqh444.qzhihu.business.callback.AdvancedSubscriber;
import com.gmail.mqh444.qzhihu.business.pojo.bean.LastThemeStory;
import com.gmail.mqh444.qzhihu.business.pojo.bean.ThemeItem;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetThemeResponse;
import com.gmail.mqh444.qzhihu.ui.base.common.DividerItemDecoration;
import com.gmail.mqh444.qzhihu.ui.base.common.FragmentLauncher;
import com.gmail.mqh444.qzhihu.ui.base.mvp.MvpFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * OtherThemeFragment
 * Created by Louis on 2016/11/14.
 */

public class OtherThemeFragment extends MvpFragment<OtherThemePresenter, OtherThemePresenter.IHomeView> {

    static final String EXTRA_ITEM = "themeItem";

    public static OtherThemeFragment newInstance(ThemeItem themeItem){
        OtherThemeFragment fragment = new OtherThemeFragment();
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_ITEM, themeItem);
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    ThemeItem themeItem;
    MyAdapter adapter;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        themeItem = (ThemeItem) getArguments().getSerializable(EXTRA_ITEM);

        adapter = new MyAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);

        // 添加item分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST));

        setTitle(themeItem.getName());

        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh(){
                doGetRequest();
            }
        });
        doGetRequest();
    }

    private void doGetRequest() {
        presenter.doGetThemeById(themeItem.getId())
                .subscribe(new AdvancedSubscriber<GetThemeResponse>(){
                   @Override
                    public void onHandleSuccess(GetThemeResponse response){
                       super.onHandleSuccess(response);
                       update(response);
                   }
                });
    }

    void update(GetThemeResponse response) {
        adapter.notifyDataSetChanged(response);
        swipeRefreshLayout.setRefreshing(false);
    }

    class MyAdapter extends RecyclerView.Adapter {

        static final int TYPE_HEADER = 1;
        static final int TYPE_ITEM = 2;
        static final int TYPE_TITLE = 3;

        List<Object> data;
        GetThemeResponse getThemeResponse;

        MyAdapter(){
            data = new ArrayList<>();
        }

        @Override
        public int getItemViewType(int position) {
            if (position == 0){
                return TYPE_HEADER;
            }else if (data.get(position) instanceof LastThemeStory){
                return TYPE_ITEM;
            }
            return TYPE_TITLE;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (viewType == TYPE_HEADER){
                return new TypeHeader(layoutInflater.inflate(R.layout.item_top_item_fragment, parent, false));
            }else if (viewType == TYPE_ITEM){
                return new TypeItem(layoutInflater.inflate(R.layout.item_last_item,parent,false));
            }else {
                return new TypeTitle(layoutInflater.inflate(R.layout.item_last_title,parent,false));
            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof TypeHeader) {
                TypeHeader item = (TypeHeader) holder;
                item.bind(getThemeResponse);
            }else if(holder instanceof TypeItem) {
                TypeItem item = (TypeItem) holder;
                item.bind((LastThemeStory) data.get(position - 1));
            }else if (holder instanceof TypeTitle){
                TypeTitle item = (TypeTitle) holder;
                item.bind((String) data.get(position - 1));
            }
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        void notifyDataSetChanged(GetThemeResponse response){
            data.clear();
            data.addAll(Arrays.asList(response.getStories()));
            this.getThemeResponse = response;

            super.notifyDataSetChanged();
        }
    }

    @Override
    protected OtherThemePresenter.IHomeView getViewInstance() {
        return new OtherThemePresenter.IHomeView() {
        };
    }

    static class TypeHeader extends RecyclerView.ViewHolder {

        @BindView(R.id.text)
        TextView textView;
        @BindView(R.id.icon)
        ImageView icon;

        public TypeHeader(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(GetThemeResponse response){
            textView.setText(response.getName());
            Picasso.with(icon.getContext())
                    .load(response.getImage())
                    .into(icon);
        }
    }

    static class TypeTitle extends RecyclerView.ViewHolder {

        @BindView(R.id.text)
        TextView textView;

        public TypeTitle(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(String text){
            textView.setText(text);
        }
    }


    static class TypeItem extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.text)
        TextView textView;
        @BindView(R.id.icon)
        ImageView icon;

        public TypeItem(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);

            itemView.setOnClickListener(this);
        }

        void bind(LastThemeStory story){
            itemView.setTag(story);
            textView.setText(story.getTitle());
            if (story.getImages() != null && story.getImages().length > 0){
                Picasso.with(icon.getContext())
                        .load(story.getImages()[0])
                        .placeholder(R.drawable.ic_launcher)
                        .into(icon);
            }
        }

        @Override
        public void onClick(View view) {
            LastThemeStory story = (LastThemeStory) view.getTag();
            DetailFragment.DetailExtraParam param = new DetailFragment.DetailExtraParam();
            param.setFragmentClass(DetailFragment.class);
            param.id = story.getId();
            FragmentLauncher.launch(view.getContext(), param);
        }
    }
}
