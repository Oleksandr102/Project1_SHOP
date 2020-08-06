package main.java.com.company.dao.users.impl;

import main.java.com.company.dao.users.UserService;
import main.java.com.company.model.user.User;
import main.java.com.company.model.user.enums.Rights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static List<User> users = new ArrayList<>(Arrays.asList(
            new User("admin", "admin", Rights.ADMIN),
            new User("user", "user")
    ));

    @Override
    public void userAdd(String login, String password) {

    }

    @Override
    public void userShowByLogin(String login) {

    }

    @Override
    public void userShowAll() {

    }

    @Override
    public void userBlock(int id) {

    }

    @Override
    public void userUnblock(int id) {

    }
}
