package com.nekodev.paulina.sadowska.githubuserlist.data.remote;

import com.nekodev.paulina.sadowska.githubuserlist.model.User;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Paulina Sadowska on 14.08.2016.
 */

public interface GitHubService {

    String ENDPOINT = "https://api.github.com/";

    @GET("users")
    Observable<List<User>> getUsers();
}
