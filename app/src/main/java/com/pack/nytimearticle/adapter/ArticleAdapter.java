package com.pack.nytimearticle.adapter;

import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.pack.nytimearticle.Utils.Constants;
import com.pack.nytimearticle.DetailActivity;
import com.pack.nytimearticle.interfaceListener.ArticleListener;
import com.pack.nytimearticle.R;
import com.pack.nytimearticle.databinding.ArticleItemBinding;
import com.pack.nytimearticle.model.Result;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleAdapter  extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> implements ArticleListener {



        private ArrayList<Result> articleModelsList;
        private Context context;

    public ArticleAdapter(Context mainActivity) {
        this.context=mainActivity;
    }


    @NonNull
        @Override
        public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            ArticleItemBinding employeeListItemBinding =
                    DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                            R.layout.article_item, viewGroup, false);
            return new ArticleViewHolder(employeeListItemBinding);
        }

        @Override
        public void onBindViewHolder(@NonNull ArticleViewHolder articleViewHolder, int i) {
            Result currentArticle = articleModelsList.get(i);
            articleViewHolder.articleListItemBinding.setArticleModelResult(currentArticle);
            articleViewHolder.articleListItemBinding.setItemClickListener(this);
        }

        @Override
        public int getItemCount() {
            if (articleModelsList != null) {
                return articleModelsList.size();
            } else {
                return 0;
            }
        }

        public void setArticleModelsList(ArrayList<Result> articleModels) {
            this.articleModelsList = articleModels;
            notifyDataSetChanged();
        }

    @Override
    public void getArticle(Result result) {
        Intent intent=new Intent(context, DetailActivity.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable(Constants.RESULTDATA,result);
        intent.putExtras(bundle);
        context.startActivity(intent);

    }

    class ArticleViewHolder extends RecyclerView.ViewHolder {

            private ArticleItemBinding articleListItemBinding;

            public ArticleViewHolder(@NonNull ArticleItemBinding articleListItemBinding) {
                super(articleListItemBinding.getRoot());

                this.articleListItemBinding = articleListItemBinding;
            }
        }

}
