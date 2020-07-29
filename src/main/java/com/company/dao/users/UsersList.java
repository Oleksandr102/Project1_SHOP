package main.java.com.company.dao.users;

import main.java.com.company.model.user.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsersList {
    public static List<User> users = new ArrayList<>(Arrays.asList(
            new User("admin", "admin", "Admin"),
            new User("user", "user", "User")
    ));
}
