package com.nekodev.paulina.sadowska.githubuserlist.model;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Paulina Sadowska on 17.08.2016.
 */

public class UserDetails implements Serializable {

    @SerializedName("login")
    @Expose
    private String login;

    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("bio")
    @Expose
    private String bio;

    public UserDetails(String login, String avatar_url, String name, String bio){
        this.login = login;
        this.avatarUrl = avatar_url;
        this.name = name;
        this.bio = bio;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @BindingAdapter({"bind:avatarUrl"})
    public static void loadImage(ImageView imageView, String imageUrl) {
        Glide
                .with(imageView.getContext())
                .load(imageUrl)
                .into(imageView);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
