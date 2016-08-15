package com.nekodev.paulina.sadowska.tests.util;

import android.content.Context;

import com.nekodev.paulina.sadowska.githubuserlist.GitHubUsersApplication;
import com.nekodev.paulina.sadowska.githubuserlist.data.DataManager;
import com.nekodev.paulina.sadowska.githubuserlist.data.remote.GitHubService;
import com.nekodev.paulina.sadowska.tests.injection.components.ApplicationTestComponent;
import com.nekodev.paulina.sadowska.tests.injection.components.DaggerDataManagerTestComponent;
import com.nekodev.paulina.sadowska.tests.injection.module.DataManagerTestModule;

/**
 * Created by Paulina Sadowska on 15.08.2016.
 */

public class TestDataManager extends DataManager {

    public TestDataManager(Context context) {
        super(context);
    }

    @Override
    protected void injectDependencies(Context context) {
        ApplicationTestComponent testComponent = (ApplicationTestComponent)
                GitHubUsersApplication.get(context).getComponent();
        DaggerDataManagerTestComponent.builder()
                .applicationTestComponent(testComponent)
                .dataManagerTestModule(new DataManagerTestModule())
                .build()
                .inject(this);
    }

    public GitHubService getGitHubService() {
        return mGitHubService;
    }

}
