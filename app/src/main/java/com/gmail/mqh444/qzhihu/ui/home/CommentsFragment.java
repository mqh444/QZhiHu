package com.gmail.mqh444.qzhihu.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleCursorTreeAdapter;
import android.widget.TextView;

import com.gmail.mqh444.qzhihu.R;
import com.gmail.mqh444.qzhihu.business.callback.AdvancedSubscriber;
import com.gmail.mqh444.qzhihu.business.pojo.bean.Comment;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetLongCommentsResponse;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetStoryExtraResponse;
import com.gmail.mqh444.qzhihu.ui.base.common.CommonExtraParam;
import com.gmail.mqh444.qzhihu.ui.base.common.CommonMvpFragment;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * CommentsFragment
 * Created by Louis on 2016/11/12.
 */

public class CommentsFragment extends CommonMvpFragment<CommentsPresenter, CommentsPresenter.ICommentsView> {

    public static class CommentsExtraParam extends CommonExtraParam{

        public int id;
        public GetStoryExtraResponse storyExtraResponse;

        @Override
        public String toString() {
            return "CommentsFragment{" +
                    "id=" + id +
                    ", storyExtraResponse=" + storyExtraResponse +
                    "} " + super.toString();
        }
    }

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    CommentsExtraParam commentsExtraParam;
    List<Object> data;
    MyAdapter adapter;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_comments;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        commentsExtraParam = getExtraReqParam();

        data = new ArrayList<>();
        data.add(commentsExtraParam.storyExtraResponse.getLongComments());
        adapter = new MyAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        doGetRequest();
    }

    void doGetRequest() {
        presenter.doGetLongCommentsById(commentsExtraParam.id)
                .subscribe(new AdvancedSubscriber<GetLongCommentsResponse>(){
                    @Override
                    public void onHandleSuccess(GetLongCommentsResponse response){
                        super.onHandleSuccess(response);

                        adapter.notifLong(response);
                    }
                });
    }

    class MyAdapter extends RecyclerView.Adapter {

        static final int TYPE_TITLE = 1;
        static final int TYPE_ITEM = 2;

        @Override
        public int getItemViewType(int position) {
            if (data.get(position) instanceof Integer){
                return TYPE_TITLE;
            }
            return TYPE_ITEM;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (viewType == TYPE_ITEM){
                return new TypeItem(layoutInflater.inflate(R.layout.item_last_comment, parent, false));
            }else {
                return new TypeItem(layoutInflater.inflate(R.layout.item_last_title, parent, false));
            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof TypeItem){
                TypeItem item = (TypeItem) holder;
                item.bind((Comment) data.get(position));
            }else if (holder instanceof TypeTitle){
                TypeTitle item = (TypeTitle) holder;
                item.bind(Integer) data.get(position);
            }
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        void notifLong(GetLongCommentsResponse response) {
            data.clear();
            data.add(commentsExtraParam.storyExtraResponse.getLongComments());
            data.addAll(Array.asList(response.getComments()));
            data.add(commentsExtraParam.storyExtraResponse.getShortComments());

            super.notifyDataSetChanged();
        }

        void notifShort(GetStoryExtraResponse response){
            data.addAll(Arrays.asList(response.getComments()));

            super.notifyDataSetChanged();
        }
    }

    class TypeTitle extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.text)
        TextView textView;

        public TypeTitle(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        void bind(Integer count){
            if (getAdapterPosition() == 0){
                textView.setText(String.format("%d条长评论", count));
            }else {
                textView.setText(String.format("%d条短评论", count));
            }
        }

        @Override
        public void onClick(View view) {
            // 不是第一个
            if (getAdapterPosition() != 0 && !presenter.isLoadShort()){
                presenter.
            }
        }
    }
}
