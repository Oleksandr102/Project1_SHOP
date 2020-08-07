package main.java.com.company.service;

import main.java.com.company.model.user.User;
import main.java.com.company.model.user.enums.Rights;
import main.java.com.company.model.user.enums.Status;
import main.java.com.company.service.exceptions.LoginAlreadyInUseException;
import main.java.com.company.service.interfaces.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static List<User> users = new ArrayList<>(Arrays.asList(
            new User("admin", "admin", Rights.ADMIN),
            new User("user", "user")
    ));

    @Override
    public void userAdd(String login, String password) throws LoginAlreadyInUseException {
        int count = (int) users.stream()
                .filter(u -> u.getLogin().equals(login))
                .count();

        if (count == 0) {
            users.add(new User(login, password));
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
                .forEach(u -> u.setStatus(Status.BLOCKED));
    }

    @Override
    public void userUnblock(int id) {
        users.stream()
                .filter(u -> u.getId() == (id))
                .forEach(u -> u.setStatus(Status.ACTIVE));
    }
}
