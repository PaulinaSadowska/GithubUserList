package com.nekodev.paulina.sadowska.githubuserlist.injection.module;

/**
 * Created by Paulina Sadowska on 15.08.2016.
 */

import com.nekodev.paulina.sadowska.githubuserlist.data.remote.GitHubService;
import com.nekodev.paulina.sadowska.githubuserlist.data.remote.RetrofitHelper;
import com.nekodev.paulina.sadowska.githubuserlist.injection.scope.PerDataManager;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Provide dependencies to the DataManager, mainly Helper classes and Retrofit services.
 */
@Module
public class DataManagerModule {

    public DataManagerModule() {

    }

    @Provides
    @PerDataManager
    GitHubService provideGitHubService() {
        return new RetrofitHelper().newHackerNewsService();
    }

    @Provides
    @PerDataManager
    Scheduler provideSubscribeScheduler() {
        return Schedulers.io();
    }
}
