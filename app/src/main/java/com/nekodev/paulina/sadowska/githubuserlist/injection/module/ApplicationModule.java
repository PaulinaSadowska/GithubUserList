package com.nekodev.paulina.sadowska.githubuserlist.injection.module;

/**
 * Created by Paulina Sadowska on 15.08.2016.
 */

import android.app.Application;

import com.nekodev.paulina.sadowska.githubuserlist.data.DataManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Provide application-level dependencies. Mainly singleton object that can be injected from
 * anywhere in the app.
 */
@Module
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application application) {
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
        return new DataManager(mApplication);
    }

}
