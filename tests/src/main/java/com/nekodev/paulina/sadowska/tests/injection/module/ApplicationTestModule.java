package com.nekodev.paulina.sadowska.tests.injection.module;


import android.app.Application;

import com.nekodev.paulina.sadowska.githubuserlist.data.DataManager;
import com.nekodev.paulina.sadowska.tests.util.TestDataManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Provides application-level dependencies for an app running on a testing environment
 * This allows injecting mocks if necessary.
 */
@Module
public class ApplicationTestModule {
    private final Application mApplication;

    public ApplicationTestModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    DataManager provideDataManager() {
        return new TestDataManager(mApplication);
    }

}
