package com.nekodev.paulina.sadowska.githubuserlist.util;

import com.nekodev.paulina.sadowska.githubuserlist.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paulina Sadowska on 15.08.2016.
 */

public class MockModelUtil {

    private static final String DUMMY_AVATAR_URL = "http://images.freeimages.com/images/previews/97d/cats-1343481.jpg";

    public static User createMockUser() {
        return createMockUser("Ana");
    }

    public static User createMockUser(String name) {
        return new User(name, DUMMY_AVATAR_URL);
    }

    public static List<User> createMockUserList(int size) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            users.add(createMockUser("Ana " + i));
        }
        return users;
    }
}
