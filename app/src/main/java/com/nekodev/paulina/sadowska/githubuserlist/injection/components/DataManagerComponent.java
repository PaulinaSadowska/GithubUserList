package com.nekodev.paulina.sadowska.githubuserlist.injection.components;

import com.nekodev.paulina.sadowska.githubuserlist.data.DataManager;
import com.nekodev.paulina.sadowska.githubuserlist.injection.module.DataManagerModule;
import com.nekodev.paulina.sadowska.githubuserlist.injection.scope.PerDataManager;

import dagger.Component;

/**
 * Created by Paulina Sadowska on 15.08.2016.
 */

@PerDataManager
@Component(dependencies = ApplicationComponent.class, modules = DataManagerModule.class)
public interface DataManagerComponent {

    void inject(DataManager dataManager);
}
