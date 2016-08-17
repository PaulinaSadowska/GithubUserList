package com.nekodev.paulina.sadowska.tests;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.nekodev.paulina.sadowska.githubuserlist.R;
import com.nekodev.paulina.sadowska.githubuserlist.view.activities.DetailsActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Paulina Sadowska on 17.08.2016.
 */


@RunWith(AndroidJUnit4.class)
public class DetailsActivityTest {

    @Rule
    public final ActivityTestRule<DetailsActivity> details =
            new ActivityTestRule<>(DetailsActivity.class, false, false);

    @Test
    public void testDetailsActivityOpens() {
        details.launchActivity(null);
        onView(withId(R.id.content_frame)).check(matches(isDisplayed()));
    }
}
