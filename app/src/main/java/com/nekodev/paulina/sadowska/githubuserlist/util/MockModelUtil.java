package com.nekodev.paulina.sadowska.githubuserlist.util;

import com.nekodev.paulina.sadowska.githubuserlist.model.User;
import com.nekodev.paulina.sadowska.githubuserlist.model.UserDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paulina Sadowska on 15.08.2016.
 */

public class MockModelUtil {

    private static final String DUMMY_AVATAR_URL = "http://images.freeimages.com/images/previews/97d/cats-1343481.jpg";
    public static final String DUMMY_LOGIN = "PaulinaSadowska";

    public static User createMockUser() {
        return createMockUser(DUMMY_LOGIN);
    }

    public static User createMockUser(String name) {
        return new User(name, DUMMY_AVATAR_URL);
    }

    public static List<User> createMockUserList(int size) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            users.add(createMockUser(DUMMY_LOGIN + " " + i));
        }
        return users;
    }

    public static UserDetails createMockUserDetails() {
        return new UserDetails(DUMMY_LOGIN, DUMMY_AVATAR_URL, "Anna Karenina", "My not so short story began...");
    }
}
