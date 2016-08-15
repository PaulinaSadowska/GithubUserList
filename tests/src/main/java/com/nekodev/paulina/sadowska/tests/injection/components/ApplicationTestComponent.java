package com.nekodev.paulina.sadowska.tests.injection.components;

import com.nekodev.paulina.sadowska.githubuserlist.injection.components.ApplicationComponent;
import com.nekodev.paulina.sadowska.tests.injection.module.ApplicationTestModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Paulina Sadowska on 15.08.2016.
 */

@Singleton
@Component(modules = ApplicationTestModule.class)
public interface ApplicationTestComponent extends ApplicationComponent {

}