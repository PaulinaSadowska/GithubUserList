package com.nekodev.paulina.sadowska.githubuserlist.model;

/**
 * Created by Paulina Sadowska on 14.08.2016.
 */

public class User {

    private String userName;
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

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
