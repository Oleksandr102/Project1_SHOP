package main.java.com.company.service;

import main.java.com.company.authorization.exception.LoginAlreadyInUseException;
import main.java.com.company.model.user.User;
import main.java.com.company.model.user.enums.Rights;
import main.java.com.company.model.user.enums.Status;
import main.java.com.company.service.interfaces.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static main.java.com.company.authorization.config.Scanner.ReadString;

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
            user.setPassword(ReadString());
            System.out.print("Enter name:     ");
            user.setName(ReadString());
            System.out.print("Enter seName:   ");
            user.setSeName(ReadString());
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
                .forEach(u -> u.setStatus(Status.BLOCKED));
    }

    @Override
    public void userUnblock(int id) {
        users.stream()
                .filter(u -> u.getId() == (id))
                .forEach(u -> u.setStatus(Status.ACTIVE));
    }
}
