package main.java.com.company.authorization.view.impl;

import lombok.SneakyThrows;
import main.java.com.company.authorization.exception.StringException;
import main.java.com.company.authorization.view.AuthorizationMenu;
import main.java.com.company.model.user.User;
import main.java.com.company.model.user.enums.Rights;
import main.java.com.company.service.UserServiceImpl;
import main.java.com.company.service.interfaces.UserService;
import main.java.com.company.view.AdminMenu;
import main.java.com.company.view.UserMenu;

import static main.java.com.company.authorization.config.Scanner.ReadString;

public class AuthorizationMenuImpl implements AuthorizationMenu {
    private static UserService userService = new UserServiceImpl();

    @SneakyThrows
    public void authorization() {
        Integer count;
        loop:
        while (true) {
            System.out.println("1-Registration 2-Login 3-Exit");
            try {
                count = Integer.parseInt(ReadString());
            } catch (NumberFormatException e) {
                e.getMessage();
                throw new StringException("Input number");
            }
            switch (count) {
                case 1 -> {
                    System.out.print("Enter login:    ");
                    new UserServiceImpl().userAdd(ReadString());
                }
                case 2 -> login();
                case 3 -> {
                    System.out.println("Exit");
                    break loop;
                }
            }
        }
    }

    @SneakyThrows
    @Override
    public void login() {
        System.out.print("Enter login: ");
        User user = userService.userShowByLogin(ReadString());
        if (user.getRights().equals(Rights.ADMIN)) {
            password();
            new AdminMenu().runAdminMenu();
        } else {
            password();
            new UserMenu().dropMenu();
        }
    }

    @Override
    public void password() {
        System.out.print("Password:    ");
        User user = userService.userCheckByPassword(ReadString());
        if (user.getPassword() != null) {
            System.out.println("login:" + user);
        } else {
            System.out.println("password error");
        }
    }
}
