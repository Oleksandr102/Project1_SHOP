package com.company.dao.users;

import com.company.model.user.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsersList {
    public static List<User> users = new ArrayList<>(Arrays.asList(
            new User("admin", "admin", "Admin"),
            new User("user", "user", "User")
    ));
}
