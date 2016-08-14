package com.nekodev.paulina.sadowska.githubuserlist.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Paulina Sadowska on 14.08.2016.
 */


public class RetrofitHelper {

    private Gson gson = new GsonBuilder()
            .create();

    public GitHubService newHackerNewsService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GitHubService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(GitHubService.class);
    }

}