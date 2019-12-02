package com.pack.nytimearticle.networkbuilder;

import com.pack.nytimearticle.interfaceListener.ResultDataService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://api.nytimes.com/svc/mostpopular/v2/";

    public static ResultDataService getService() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(ResultDataService.class);
    }
}
