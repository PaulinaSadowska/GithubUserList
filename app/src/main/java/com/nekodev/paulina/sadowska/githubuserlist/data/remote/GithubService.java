package com.nekodev.paulina.sadowska.githubuserlist.data.remote;

import com.nekodev.paulina.sadowska.githubuserlist.model.User;
import com.nekodev.paulina.sadowska.githubuserlist.model.UserDetails;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Paulina Sadowska on 14.08.2016.
 */

public interface GitHubService {

    String ENDPOINT = "https://api.github.com/";

    @GET("users")
    Observable<List<User>> getUsers();

    @GET("users/{login}")
    Observable<UserDetails> getUserDetails(@Path("login") String user);
}
