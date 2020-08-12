package com.company.authorization.view.impl;

import lombok.SneakyThrows;
import com.company.authorization.exception.StringException;
import com.company.authorization.view.AuthorizationMenu;
import com.company.model.user.User;
import com.company.model.user.enums.Rights;
import com.company.service.UserServiceImpl;
import com.company.service.interfaces.UserService;
import com.company.view.AdminMenu;
import com.company.view.UserMenu;

import static com.company.authorization.config.Scanner.ReadString;

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
