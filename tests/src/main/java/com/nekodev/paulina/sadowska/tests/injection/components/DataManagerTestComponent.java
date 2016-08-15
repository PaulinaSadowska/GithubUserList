package com.nekodev.paulina.sadowska.tests.injection.components;

import com.nekodev.paulina.sadowska.githubuserlist.injection.components.DataManagerComponent;
import com.nekodev.paulina.sadowska.githubuserlist.injection.scope.PerDataManager;
import com.nekodev.paulina.sadowska.tests.injection.module.DataManagerTestModule;

import dagger.Component;

/**
 * Created by Paulina Sadowska on 15.08.2016.
 */

@PerDataManager
@Component(dependencies = ApplicationTestComponent.class, modules = DataManagerTestModule.class)
public interface DataManagerTestComponent extends DataManagerComponent {
}