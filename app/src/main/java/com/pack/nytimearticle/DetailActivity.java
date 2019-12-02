package com.pack.nytimearticle;


import android.os.Bundle;

import com.pack.nytimearticle.Utils.Constants;
import com.pack.nytimearticle.model.Result;
import com.pack.nytimearticle.databinding.DetailActivityBinding;
import com.pack.nytimearticle.model.DetailArticleModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class DetailActivity extends AppCompatActivity
{

    private Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if(getIntent().getExtras()!=null)
        {
            result=(Result) getIntent().getExtras().getSerializable(Constants.RESULTDATA);
            DetailActivityBinding detailActivityBinding=DataBindingUtil.setContentView(this,R.layout.detail_activity);
            DetailArticleModel detailArticleModel=new DetailArticleModel();
            detailArticleModel.setBody(result.getAbstract());
            detailArticleModel.setTitle(result.getTitle());
            detailArticleModel.setProfileImage(result.getMedia().get(0).getMediaMetadata().get(0).getUrl());
            detailActivityBinding.setDetailArticleModel(detailArticleModel);
        }

    }





}
