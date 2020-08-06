package com.company.service;

import com.company.service.interfaces.UserService;
import com.company.model.user.User;
import com.company.model.user.enums.Rights;
import com.company.model.user.enums.Status;

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
        users.add(new User(login, password));
    }

    @Override
    public void userShowByLogin(String login) {
        users.stream()
                .filter(u -> u.getLogin().equals(login))
                .forEach(System.out::println);
    }

    @Override
    public void userShowAll() {
        for (User u : users) {
            System.out.println(u.toString());
        }
    }

    @Override
    public void userBlock(int id) {
        users.stream()
                .filter(u -> u.getId() == (id))
                .forEach(u -> u.setStatus(Status.BLOCKED));
    }

    @Override
    public void userUnblock(int id) {
        users.stream()
                .filter(u -> u.getId() == (id))
                .forEach(u -> u.setStatus(Status.ACTIVE));
    }
}
