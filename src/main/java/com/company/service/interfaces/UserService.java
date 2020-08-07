package com.company.service.interfaces;

import main.java.com.company.model.user.User;
import main.java.com.company.service.exceptions.LoginAlreadyInUseException;

public interface UserService {
    void userAdd(String login, String password) throws LoginAlreadyInUseException;

    User userShowByLogin(String login);

    User userCheckByPassword(String password);

    void userShowAll();

    void userBlock(int id);

    void userUnblock(int id);
}
