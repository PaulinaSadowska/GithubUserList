package com.nekodev.paulina.sadowska.githubuserlist.data;


import android.content.Context;

import com.nekodev.paulina.sadowska.githubuserlist.GitHubUsersApplication;
import com.nekodev.paulina.sadowska.githubuserlist.data.remote.GitHubService;
import com.nekodev.paulina.sadowska.githubuserlist.injection.components.DaggerDataManagerComponent;
import com.nekodev.paulina.sadowska.githubuserlist.injection.module.DataManagerModule;
import com.nekodev.paulina.sadowska.githubuserlist.model.User;
import com.nekodev.paulina.sadowska.githubuserlist.model.UserDetails;

import javax.inject.Inject;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by Paulina Sadowska on 14.08.2016.
 */

public class DataManager  {

    @Inject protected GitHubService mGitHubService;
    @Inject protected Scheduler mSubscribeScheduler;

    public DataManager(Context context) {
        injectDependencies(context);
    }

    /* This constructor is provided so we can set up a DataManager with mocks from unit test.
     * At the moment this is not possible to do with Dagger because the Gradle APT plugin doesn't
     * work for the unit test variant, plus Dagger 2 doesn't provide a nice way of overriding
     * modules */
    public DataManager(GitHubService gitHubService,
                       Scheduler subscribeScheduler) {
        mGitHubService = gitHubService;
        mSubscribeScheduler = subscribeScheduler;
    }

    protected void injectDependencies(Context context) {
        DaggerDataManagerComponent.builder()
                .applicationComponent(GitHubUsersApplication.get(context).getComponent())
                .dataManagerModule(new DataManagerModule())
                .build()
                .inject(this);
    }

    public Observable<User> getUsers(){
        return mGitHubService.getUsers()
                .flatMap(Observable::from);
    }

    public Observable<UserDetails> getUserDetails(String login){
        return mGitHubService.getUserDetails(login);
    }

    public Scheduler getScheduler() {
        return mSubscribeScheduler;
    }
}
