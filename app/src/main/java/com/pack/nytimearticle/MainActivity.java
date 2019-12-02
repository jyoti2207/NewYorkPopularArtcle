package com.pack.nytimearticle;



import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;

import com.pack.nytimearticle.viewModel.MainViewModel;
import com.pack.nytimearticle.adapter.ArticleAdapter;
import com.pack.nytimearticle.databinding.ActivityMainBinding;
import com.pack.nytimearticle.model.Result;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity
{
    private MainViewModel mainViewModel;
    private ArticleAdapter articleAdapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding=DataBindingUtil.setContentView(this,R.layout.activity_main);
        RecyclerView recyclerView = activityMainBinding.viewArticleList;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        context=this;
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        articleAdapter = new ArticleAdapter(context);
        recyclerView.setAdapter(articleAdapter);
        getAllArticleList();

    }

    private void getAllArticleList() {
        mainViewModel.getAllArticleList().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(@Nullable List<Result> results) {
                articleAdapter.setArticleModelsList((ArrayList<Result>) results);
            }
        });
    }



}
