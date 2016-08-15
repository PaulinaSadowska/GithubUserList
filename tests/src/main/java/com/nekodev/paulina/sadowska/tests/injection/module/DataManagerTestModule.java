package com.nekodev.paulina.sadowska.tests.injection.module;

import com.nekodev.paulina.sadowska.githubuserlist.data.remote.GitHubService;
import com.nekodev.paulina.sadowska.githubuserlist.injection.scope.PerDataManager;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.schedulers.Schedulers;

import static org.mockito.Mockito.mock;

/**
 * Provides dependencies for an app running on a testing environment
 * This allows injecting mocks if necessary
 */
@Module
public class DataManagerTestModule {

    public DataManagerTestModule() { }

    @Provides
    @PerDataManager
    GitHubService provideGitHubService() {
        return mock(GitHubService.class);
    }

    @Provides
    @PerDataManager
    Scheduler provideSubscribeScheduler() {
        return Schedulers.immediate();
    }
}

