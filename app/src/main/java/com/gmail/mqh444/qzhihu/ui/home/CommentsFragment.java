package com.gmail.mqh444.qzhihu.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.mqh444.qzhihu.R;
import com.gmail.mqh444.qzhihu.business.callback.AdvancedSubscriber;
import com.gmail.mqh444.qzhihu.business.pojo.bean.Comment;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetLongCommentsResponse;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetShortCommentsResponse;
import com.gmail.mqh444.qzhihu.business.pojo.response.ext.GetStoryExtraResponse;
import com.gmail.mqh444.qzhihu.ui.base.common.CommonExtraParam;
import com.gmail.mqh444.qzhihu.ui.base.common.CommonMvpFragment;
import com.gmail.mqh444.qzhihu.ui.base.common.DividerItemDecoration;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

        // 添加item分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST));

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
                return new TypeTitle(layoutInflater.inflate(R.layout.item_last_title, parent, false));
            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof TypeItem){
                TypeItem item = (TypeItem) holder;
                item.bind((Comment) data.get(position));
            }else if (holder instanceof TypeTitle){
                TypeTitle item = (TypeTitle) holder;
                item.bind((Integer) data.get(position));
            }
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        void notifLong(GetLongCommentsResponse response) {
            data.clear();
            data.add(commentsExtraParam.storyExtraResponse.getLongComments());
            data.addAll(Arrays.asList(response.getComments()));
            data.add(commentsExtraParam.storyExtraResponse.getShortComments());

            super.notifyDataSetChanged();
        }

        void notifShort(GetShortCommentsResponse response){
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
        public void onClick(View v) {
            // 不是第一个
            if (getAdapterPosition() != 0 && !presenter.isLoadShort()){
                presenter.doGetShortComments(commentsExtraParam.id)
                        .subscribe(new AdvancedSubscriber<GetShortCommentsResponse>(mvpActivity){
                            @Override
                            public void onHandleSuccess(GetShortCommentsResponse response){
                                super.onHandleSuccess(response);

                                adapter.notifShort(response);

                                int top = itemView.getTop();
                                recyclerView.scrollBy(0, top);
                            }
                        });
            }
        }
    }

    static class TypeItem extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.text)
        @Nullable
        TextView textView;

        @BindView(R.id.text2)
        @Nullable
        TextView textView2;

        @BindView(R.id.text3)
        @Nullable
        TextView textView3;

        @BindView(R.id.icon)
        @Nullable
        ImageView icon;

        SimpleDateFormat simpleDateFormat;

        public TypeItem(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
            textView.setSingleLine();
        }

        void bind(Comment comment){
            itemView.setTag(comment);
            textView.setText(comment.getAuthor());
            textView2.setText(comment.getContent());
            textView3.setText(simpleDateFormat.format(new Date(comment.getTime() * 1000L)));

            if (TextUtils.isEmpty(comment.getAvatar())){
                icon.setImageResource(0);
            }else {
                Picasso.with(icon.getContext())
                        .load(comment.getAvatar())
                        .placeholder(R.drawable.ic_launcher)
                        .into(icon);
            }
        }

        @Override
        public void onClick(View v){}
    }

    @Override
    protected CommentsPresenter.ICommentsView getViewInstance() {
        return new CommentsPresenter.ICommentsView(){
        };
    }
}
