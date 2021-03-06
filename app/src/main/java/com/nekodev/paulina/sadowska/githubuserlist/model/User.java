package com.nekodev.paulina.sadowska.githubuserlist.model;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Paulina Sadowska on 14.08.2016.
 */

public class User implements Serializable {


    @SerializedName("login")
    @Expose
    private String userName;
    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;

    public User(){
    }

    public User(String userName, String avatarUrl){
        this.userName = userName;
        this.avatarUrl = avatarUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    @BindingAdapter({"bind:avatarUrl"})
    public static void loadImage(ImageView imageView, String imageUrl) {
        Glide
                .with(imageView.getContext())
                .load(imageUrl)
                .into(imageView);
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
