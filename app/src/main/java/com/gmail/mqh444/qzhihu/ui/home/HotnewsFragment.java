package com.gmail.mqh444.qzhihu.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmail.mqh444.qzhihu.business.pojo.bean.LastThemeStory;
import com.gmail.mqh444.qzhihu.business.pojo.bean.LastThemeTopStory;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetLastThemeResponse;
import com.gmail.mqh444.qzhihu.ui.base.common.CommonMvpFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * HotnewsFragment
 * Created by Louis on 2016/11/13.
 */

public class HotnewsFragment extends CommonMvpFragment<HotnewsPresenter, HotnewsPresenter.IHotnewsView> {

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    MyAdapter adapter;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_hotnews;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("今日热闻");

        adapter = new Myadapter();
    }

    class MyAdapter extends RecyclerView.Adapter{

        static final int TYPE_HEADER = 1;
        static final int TYPE_ITEM = 2;
        static final int TYPE_TITLE = 3;

        List<Object> data;
        List<LastThemeTopStory> tops;

        {
            data = new ArrayList<>();
            tops = new ArrayList<>();
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
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (viewType == TYPE_HEADER){
                FragmentManager manager = getFragmentManager();
                return new TypeHeader(layoutInflater.inflate(R.layout.item_last_header, parent, false));
            }else if (viewType == TYPE_ITEM){
                return new TypeItem(layoutInflater.inflate(R.layout.item_last_item, parent, false));
            }else{
                return new TypeTitle(layoutInflater.inflate(R.layout.item_last_title, parent, false));
            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof TypeHeader){
                TypeHeader item = (TypeHeader) holder;
                item.bind(tops);
            }else if (holder instanceof TypeItem){
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

        void notifyDataSetChanged(GetLastThemeResponse response){
            data.clear();
            data.addAll(Arrays.asList(response.getStories()));
            tops.clear();
            tops.addAll(Arrays.asList(response.getTopStories()));

            super.notifyDataSetChanged();
        }
    }

    static class TypeHeader extends RecyclerView.ViewHolder {

        @BindView(R.id.viewPager)
        ViewPager viewPager;
        FragmentManager fragmentManager;

        public TypeHeader(View itemView, FragmentManager manager){
            super(itemView);
            this.fragmentManager = manager;
            ButterKnife.bind(this, itemView);
        }

        void bind(List<LastThemeTopStory> tops){
            List<LastThemeTopStory> topsLocal = tops;
            if (tops == null){
                topsLocal = new ArrayList<>();
            }

            viewPager.setAdapter(new MyFragmentPagerAdapter(fragmentManager, topsLocal));
        }
    }

    static class MyFragmentPagerAdapter extends FragmentPagerAdapter{

        List<LastThemeTopStory> tops;

        public MyFragmentPagerAdapter(FragmentManager fm,List<LastThemeTopStory> tops){
            super(fm);
            this.tops = tops;
        }

        @Override
        public Fragment getItemId(int position) {
            TopItemFragment fragment = new TopItemFragment();
            fragment.setTopStory
            return super.getItemId(position);
        }
    }

}