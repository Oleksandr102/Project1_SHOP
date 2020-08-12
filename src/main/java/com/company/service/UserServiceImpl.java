package com.company.service;

import com.company.authorization.exception.LoginAlreadyInUseException;
import com.company.model.user.User;
import com.company.model.user.enums.Rights;
import com.company.model.user.enums.UserStatus;
import com.company.service.interfaces.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.company.config.Scanner.readString;

public class UserServiceImpl implements UserService {
    private static List<User> users = new ArrayList<>(Arrays.asList(
            new User("admin", "admin", Rights.ADMIN),
            new User("user", "user")
    ));

    @Override
    public void userAdd(String login) throws LoginAlreadyInUseException {
        User user = new User();
        int count = (int) users.stream()
                .filter(u -> u.getLogin().equals(login))
                .count();
        if (count == 0) {
            user.setLogin(login);
            System.out.print("Enter Password: ");
            user.setPassword(readString());
            System.out.print("Enter name:     ");
            user.setName(readString());
            System.out.print("Enter seName:   ");
            user.setSeName(readString());
            user.setId((int) Math.abs(Math.random() * 1000000));
            users.add(user);
            System.out.println("User saved");
        } else {
            throw new LoginAlreadyInUseException("This login is already in use!");
        }
    }

    @Override
    public User userShowByLogin(String login) {
        return users.stream()
                .filter(u -> u.getLogin().equals(login))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User userCheckByPassword(String password) {
        return users.stream()
                .filter(u -> u.getPassword().equals(password))
                .findFirst()
                .orElse(null);
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
                .forEach(u -> u.setStatus(UserStatus.BLOCKED));
    }

    @Override
    public void userUnblock(int id) {
        users.stream()
                .filter(u -> u.getId() == (id))
                .forEach(u -> u.setStatus(UserStatus.ACTIVE));
    }
}
