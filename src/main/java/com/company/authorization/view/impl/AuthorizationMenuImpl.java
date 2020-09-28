package com.company.authorization.view.impl;

import com.company.authorization.view.AuthorizationMenu;
import com.company.exception.StringException;
import com.company.model.user.User;
import com.company.model.user.enums.Rights;
import com.company.service.UserServiceImpl;
import com.company.service.interfaces.UserService;
import com.company.view.menu.AdminMenu;
import com.company.view.menu.UserMenu;
import lombok.SneakyThrows;

import static com.company.config.Scanner.readString;


public class AuthorizationMenuImpl implements AuthorizationMenu {
    private static final UserService userService = new UserServiceImpl();

    @SneakyThrows
    public void authorization() {
        Integer count;
        loop:
        while (true) {
            System.out.println("\t\tAUTHORIZATION MENU");
            System.out.println("1. Registration\n2. Login\n3. Logout");
            try {
                count = Integer.parseInt(readString());
            } catch (NumberFormatException e) {
                e.getMessage();
                throw new StringException("Input number");
            }
            switch (count) {
                case 1 -> {
                    System.out.print("Enter login:    ");
                    new UserServiceImpl().userAdd(readString());
                }
                case 2 -> new UserMenu().dropMenu();
                case 3 -> {
                    System.out.println("Exit");
                    break loop;
                }
            }
        }
    }

    @SneakyThrows
    @Override
    public User login() {
        System.out.print("Enter login: ");
        User user = userService.userShowByLogin(readString());
        if (user.getRights().equals(Rights.ADMIN)) {
            password();
            new AdminMenu().dropMenu();
        } else {
            password();
        }
        return user;
    }

    @Override
    public void password() {
        System.out.print("Password:    ");
        User user = userService.userCheckByPassword(readString());
        if (user.getPassword() != null) {
            System.out.println("login:" + user);
        } else {
            System.out.println("password error");
        }
    }
}
