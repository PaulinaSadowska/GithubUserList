package com.nekodev.paulina.sadowska;

import android.content.Context;

import com.nekodev.paulina.sadowska.githubuserlist.BuildConfig;
import com.nekodev.paulina.sadowska.githubuserlist.model.User;
import com.nekodev.paulina.sadowska.githubuserlist.util.MockModelUtil;
import com.nekodev.paulina.sadowska.githubuserlist.viewmodel.UserViewModel;
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
public class UserViewModelTest {

    private UserViewModel mUserViewModel;
    private User mUser;

    @Before
    public void setUp() {
        Context context = RuntimeEnvironment.application;
        mUser = MockModelUtil.createMockUser();
        mUserViewModel = new UserViewModel(context, mUser);
    }

    @Test
    public void shouldGetUsername() throws Exception {
        assertEquals(mUserViewModel.getUserName(), mUser.getUserName());
    }

    @Test
    public void shouldGetAvatarUrl() throws Exception {
        assertEquals(mUserViewModel.getAvatarUrl(), mUser.getAvatarUrl());
    }
}
