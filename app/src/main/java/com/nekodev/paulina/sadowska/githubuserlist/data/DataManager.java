package com.nekodev.paulina.sadowska.githubuserlist.data;


import com.nekodev.paulina.sadowska.githubuserlist.data.remote.GitHubService;
import com.nekodev.paulina.sadowska.githubuserlist.data.remote.RetrofitHelper;
import com.nekodev.paulina.sadowska.githubuserlist.model.User;

import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by Paulina Sadowska on 14.08.2016.
 */

public class DataManager  {
    private GitHubService mGitHubService;
    private Scheduler mSubscribeScheduler;

    public DataManager(){
        mGitHubService = new RetrofitHelper().newHackerNewsService();
        mSubscribeScheduler = Schedulers.newThread();
    }

    public Observable<User> getUsers(){
        return mGitHubService.getUsers()
                .flatMap(Observable::from);
    }

    public Scheduler getScheduler() {
        return mSubscribeScheduler;
    }
}
