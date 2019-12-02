package com.pack.nytimearticle.viewModel;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import androidx.databinding.BaseObservable;
import androidx.databinding.BindingAdapter;

public class DetailArticleViewModel extends BaseObservable
{
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    private String title;
    private String body;

    String profileImage;

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    @BindingAdapter({"android:profileImage"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }

}
