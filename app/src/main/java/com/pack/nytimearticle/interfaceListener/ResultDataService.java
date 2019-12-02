package com.pack.nytimearticle.interfaceListener;

import com.pack.nytimearticle.Utils.Constants;
import com.pack.nytimearticle.model.ArticleModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ResultDataService {


    @GET("viewed/7.json?api-key="+ Constants.APIKEY)
    Call<ArticleModel> getArticleList();
}
