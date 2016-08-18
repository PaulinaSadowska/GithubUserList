package com.nekodev.paulina.sadowska.tests;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.nekodev.paulina.sadowska.githubuserlist.R;
import com.nekodev.paulina.sadowska.githubuserlist.model.User;
import com.nekodev.paulina.sadowska.githubuserlist.util.MockModelUtil;
import com.nekodev.paulina.sadowska.githubuserlist.view.activities.DetailsActivity;
import com.nekodev.paulina.sadowska.githubuserlist.view.activities.MainActivity;
import com.nekodev.paulina.sadowska.tests.injection.TestComponentRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Mockito.when;

/**
 * Created by Paulina Sadowska on 15.08.2016.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public final ActivityTestRule<MainActivity> main =
            new ActivityTestRule<>(MainActivity.class, false, false);

    @Rule
    public final TestComponentRule component = new TestComponentRule();

    @Test
    public void testUsersShowAndAreScrollable() {
        List<User> userList = MockModelUtil.createMockUserList(30);
        stubMockUsers(userList);
        main.launchActivity(null);
        checkUsersDisplayOnRecyclerView(userList);
    }

    @Test
    public void testUserDetailsLaunches() {
        Intents.init();
        User user= MockModelUtil.createMockUser();
        stubMockUser(user);
        main.launchActivity(null);
        onView(withText(user.getUserName()))
                    .perform(click());
        intended(hasComponent(DetailsActivity.class.getName()));
        Intents.release();
    }


    private void stubMockUser(User user) {
        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        stubMockUsers(users);
    }

    private void stubMockUsers(List<User> users) {
            when(component.getMockGitHubService().getUsers())
                    .thenReturn(Observable.just(users));
    }

    private void checkUsersDisplayOnRecyclerView(List<User> usersToCheck) {
        for (int i = 0; i < usersToCheck.size(); i++) {
            onView(withId(R.id.recycler_users))
                    .perform(RecyclerViewActions.scrollToPosition(i));
            checkUserDisplays(usersToCheck.get(i));
        }
    }


    private void checkUserDisplays(User user) {
        onView(withText(user.getUserName()))
                .check(matches(isDisplayed()));
    }
}
