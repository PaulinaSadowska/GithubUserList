package com.nekodev.paulina.sadowska.tests.injection;

import android.support.test.InstrumentationRegistry;

import com.nekodev.paulina.sadowska.githubuserlist.GitHubUsersApplication;
import com.nekodev.paulina.sadowska.githubuserlist.data.remote.GitHubService;
import com.nekodev.paulina.sadowska.tests.injection.components.ApplicationTestComponent;
import com.nekodev.paulina.sadowska.tests.injection.components.DaggerApplicationTestComponent;
import com.nekodev.paulina.sadowska.tests.injection.module.ApplicationTestModule;
import com.nekodev.paulina.sadowska.tests.util.TestDataManager;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Test rule that creates and sets a Dagger TestComponent into the application overriding the
 * existing application component.
 * Use this rule in your test case in order for the app to use mock dependencies.
 * It also exposes some of the dependencies so they can be easily accessed from the tests, e.g. to
 * stub mocks etc.
 */
public class TestComponentRule implements TestRule {

    private ApplicationTestComponent mTestComponent;

    public TestDataManager getDataManager() {
        return (TestDataManager) mTestComponent.dataManager();
    }

    public GitHubService getMockGitHubService() {
        return getDataManager().getGitHubService();
    }

    private void setupDaggerTestComponentInApplication() {
        GitHubUsersApplication application = GitHubUsersApplication
                .get(InstrumentationRegistry.getTargetContext());
        if (application.getComponent() instanceof ApplicationTestComponent) {
            mTestComponent = (ApplicationTestComponent) application.getComponent();
        } else {
            mTestComponent = DaggerApplicationTestComponent.builder()
                    .applicationTestModule(new ApplicationTestModule(application))
                    .build();
            application.setComponent(mTestComponent);
        }
    }

    @Override
    public Statement apply(final Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    setupDaggerTestComponentInApplication();
                    base.evaluate();
                } finally {
                    mTestComponent = null;
                }
            }
        };
    }
}