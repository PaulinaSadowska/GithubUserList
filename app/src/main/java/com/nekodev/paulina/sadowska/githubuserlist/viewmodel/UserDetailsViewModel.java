package com.nekodev.paulina.sadowska.githubuserlist.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;

import com.nekodev.paulina.sadowska.githubuserlist.model.UserDetails;

/**
 * Created by Paulina Sadowska on 17.08.2016.
 */

public class UserDetailsViewModel extends BaseObservable {
    private Context mContext;
    private UserDetails mUserDetails;

    public UserDetailsViewModel(Context context, UserDetails userDetails){
        this.mContext = context;
        this.mUserDetails = userDetails;
    }

    public String getLogin(){
        return mUserDetails.getLogin();
    }

    public String getAvatarUrl(){
        return mUserDetails.getAvatarUrl();
    }

    public String getName(){
        return  mUserDetails.getName();
    }

    public String getBio(){
        return mUserDetails.getBio();
    }
}
