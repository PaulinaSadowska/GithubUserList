package com.nekodev.paulina.sadowska.githubuserlist.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;

import com.nekodev.paulina.sadowska.githubuserlist.model.User;

/**
 * Created by Paulina Sadowska on 14.08.2016.
 */

public class UserViewModel extends BaseObservable {

    private Context mContext;
    private User mUser;

    public UserViewModel(Context context, User user){
        this.mContext = context;
        this.mUser = user;
    }

    public String getUserName(){
        return mUser.getUserName();
    }

    public String getAvatarUrl(){
        return mUser.getAvatarUrl();
    }
}
