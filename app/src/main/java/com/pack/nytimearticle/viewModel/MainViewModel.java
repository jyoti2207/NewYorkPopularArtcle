package com.pack.nytimearticle.viewModel;


import android.app.Application;

import com.pack.nytimearticle.repository.ArticleRepository;
import com.pack.nytimearticle.model.Result;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class MainViewModel extends AndroidViewModel
{
    private ArticleRepository articleRepository;

    public MainViewModel(Application application) {
        super(application);
        articleRepository=new ArticleRepository();
    }

    public LiveData<List<Result>> getAllArticleList() {
        return articleRepository.getMutableLiveData();
    }
}
