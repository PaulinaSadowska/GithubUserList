package com.nekodev.paulina.sadowska.githubuserlist;

import android.app.Application;
import android.content.Context;

import com.nekodev.paulina.sadowska.githubuserlist.injection.components.ApplicationComponent;
import com.nekodev.paulina.sadowska.githubuserlist.injection.components.DaggerApplicationComponent;
import com.nekodev.paulina.sadowska.githubuserlist.injection.module.ApplicationModule;

/**
 * Created by Paulina Sadowska on 15.08.2016.
 */

public class GitHubUsersApplication extends Application {

    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static GitHubUsersApplication get(Context context) {
        return (GitHubUsersApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
