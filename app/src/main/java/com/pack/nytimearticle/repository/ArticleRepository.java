package com.pack.nytimearticle.repository;



import com.pack.nytimearticle.interfaceListener.ResultDataService;
import com.pack.nytimearticle.networkbuilder.RetrofitClient;
import com.pack.nytimearticle.model.ArticleModel;
import com.pack.nytimearticle.model.Result;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleRepository {

    private static final String TAG = "ArticleRepository";
    private ArrayList<Result> resultArrayList = new ArrayList<>();
    private MutableLiveData<List<Result>> mutableLiveData = new MutableLiveData<>();

    public ArticleRepository() {
    }

    public MutableLiveData<List<Result>> getMutableLiveData() {

        final ResultDataService userDataService = RetrofitClient.getService();

        Call<ArticleModel> call = userDataService.getArticleList();
        call.enqueue(new Callback<ArticleModel>() {
            @Override
            public void onResponse(Call<ArticleModel> call, Response<ArticleModel> response) {
                ArticleModel articleModel = response.body();
                if (articleModel != null && articleModel.getResults() != null) {
                    resultArrayList = (ArrayList<Result>) articleModel.getResults();
                    mutableLiveData.setValue(resultArrayList);
                }
            }

            @Override
            public void onFailure(Call<ArticleModel> call, Throwable t) {
                System.out.println(call.request().url());
                System.out.println(call.request().body() +t.getMessage());
            }
        });

        return mutableLiveData;
    }
}
