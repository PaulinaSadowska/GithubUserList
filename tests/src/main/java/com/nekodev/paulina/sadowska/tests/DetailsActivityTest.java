package com.nekodev.paulina.sadowska.tests;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.nekodev.paulina.sadowska.githubuserlist.R;
import com.nekodev.paulina.sadowska.githubuserlist.model.UserDetails;
import com.nekodev.paulina.sadowska.githubuserlist.util.MockModelUtil;
import com.nekodev.paulina.sadowska.githubuserlist.view.activities.DetailsActivity;
import com.nekodev.paulina.sadowska.tests.injection.TestComponentRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import rx.Observable;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Mockito.when;

/**
 * Created by Paulina Sadowska on 17.08.2016.
 */


@RunWith(AndroidJUnit4.class)
public class DetailsActivityTest {

    private UserDetails mUserDetails;
    private Intent mIntent;

    @Rule
    public final ActivityTestRule<DetailsActivity> details =
            new ActivityTestRule<>(DetailsActivity.class, false, false);

    @Rule
    public final TestComponentRule component = new TestComponentRule();

    @Before
    public void setUp(){
        mUserDetails = MockModelUtil.createMockUserDetails();
        stubMockUser(mUserDetails);
        Context targetContext = InstrumentationRegistry.getInstrumentation()
                .getTargetContext();
        mIntent = new Intent(targetContext, DetailsActivity.class);
        mIntent.putExtra(DetailsActivity.EXTRA_LOGIN, mUserDetails.getLogin());
    }

    @Test
    public void testDetailsActivityOpens() {
        details.launchActivity(null);
        onView(withId(R.id.content_frame)).check(matches(isDisplayed()));
    }

    @Test
    public void testDetailsActivityDisplaysLogin() {
        details.launchActivity(mIntent);
        checkDisplays(mUserDetails.getLogin());
    }

    @Test
    public void testDetailsActivityDisplaysName() {
        details.launchActivity(mIntent);
        checkDisplays(mUserDetails.getName());
    }

    @Test
    public void testDetailsActivityDisplaysBio() {
        details.launchActivity(mIntent);
        checkDisplays(mUserDetails.getBio());
    }


    private void stubMockUser(UserDetails userDetails) {
        when(component.getMockGitHubService().getUserDetails(MockModelUtil.DUMMY_LOGIN))
                .thenReturn(Observable.just(userDetails));
    }

    private void checkDisplays(String text){
        onView(withText(text))
                .check(matches(isDisplayed()));
    }
}
