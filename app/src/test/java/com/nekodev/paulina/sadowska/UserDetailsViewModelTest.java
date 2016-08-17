package com.nekodev.paulina.sadowska;

import android.content.Context;

import com.nekodev.paulina.sadowska.githubuserlist.BuildConfig;
import com.nekodev.paulina.sadowska.githubuserlist.model.UserDetails;
import com.nekodev.paulina.sadowska.githubuserlist.util.MockModelUtil;
import com.nekodev.paulina.sadowska.githubuserlist.viewmodel.UserDetailsViewModel;
import com.nekodev.paulina.sadowska.util.DefaultConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Paulina Sadowska on 15.08.2016.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = DefaultConfig.EMULATE_SDK, manifest = DefaultConfig.MANIFEST)
public class UserDetailsViewModelTest {

    private UserDetailsViewModel mUserDetailsViewModel;
    private UserDetails mUserDetails;

    @Before
    public void setUp() {
        Context context = RuntimeEnvironment.application;
        mUserDetails = MockModelUtil.createMockUserDetails();
        mUserDetailsViewModel = new UserDetailsViewModel(context, mUserDetails);
    }

    @Test
    public void shouldGetLogin() throws Exception {
        assertEquals(mUserDetailsViewModel.getLogin(), mUserDetails.getLogin());
    }

    @Test
    public void shouldGetAvatarUrl() throws Exception {
        assertEquals(mUserDetailsViewModel.getAvatarUrl(), mUserDetails.getAvatarUrl());
    }

    @Test
    public void shouldGetName() throws Exception {
        assertEquals(mUserDetailsViewModel.getName(), mUserDetails.getName());
    }

    @Test
    public void shouldGetBio() throws Exception {
        assertEquals(mUserDetailsViewModel.getBio(), mUserDetails.getBio());
    }
}
