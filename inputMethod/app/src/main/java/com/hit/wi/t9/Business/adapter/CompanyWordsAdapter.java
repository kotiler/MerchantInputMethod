package com.hit.wi.t9.Business.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hit.wi.t9.R;
import android.support.v7.widget.RecyclerView;


import com.hit.wi.t9.Business.entity.UserWords;

import java.util.List;

//一列话术的适配器类，作用是将一列话术加载进布局
public class CompanyWordsAdapter extends RecyclerView.Adapter<CompanyWordsAdapter.ViewHolder>{
    private List<UserWords> wordsList;        //一列话术
    Context context;

    //构造函数
    public CompanyWordsAdapter(Context context, List<UserWords> wordsList) {
        this.wordsList = wordsList;
        this.context=context;
    }

    //使用了ViewHolder就不用频繁的使用findViewById
    static class ViewHolder extends RecyclerView.ViewHolder {
        //一条图片的布局
        View imageView;
        TextView words;
        LinearLayout word_item;
        public ViewHolder(View view) {
            super(view);
           // imageView = view;
          //  price=view
            words =(TextView) view.findViewById(R.id.userWords);
            word_item=(LinearLayout) view.findViewById(R.id.word_item);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //将words_item布局嵌入父布局，words_item布局：一条话术的布局
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.words_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    //将每个图片放入到view中，即将每个图片绑定在视图上
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserWords words = wordsList.get(position);
        holder.words.setText(words.getWords());
        if(position%2==0)
            holder.word_item.setBackgroundColor(Color.parseColor("#EBEBEB"));
//             holder.words.setTextColor(Color.BLACK);
        else
            holder.word_item.setBackgroundColor(Color.parseColor("#F7F7F7"));
    }

    @Override
    public int getItemCount() {
        return wordsList.size();
    }
}