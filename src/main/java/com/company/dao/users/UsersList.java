package main.java.com.company.dao.users;

import main.java.com.company.model.Users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsersList {
    public static List<Users> users = new ArrayList<>(Arrays.asList(
            new Users("admin", "admin", "Admin"),
            new Users("user", "user", "User")
    ));
}
