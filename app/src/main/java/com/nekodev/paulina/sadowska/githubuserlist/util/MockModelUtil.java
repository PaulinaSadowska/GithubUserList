package com.nekodev.paulina.sadowska.githubuserlist.util;

import com.nekodev.paulina.sadowska.githubuserlist.model.User;

/**
 * Created by Paulina Sadowska on 15.08.2016.
 */

public class MockModelUtil {


    public static User createMockUser() {
        User user = new User("Ana", "http://images.freeimages.com/images/previews/97d/cats-1343481.jpg");
        return user;
    }

}
