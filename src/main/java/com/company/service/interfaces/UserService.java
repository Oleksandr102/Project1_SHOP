package com.company.service.interfaces;

import main.java.com.company.authorization.exception.LoginAlreadyInUseException;
import main.java.com.company.model.user.User;

public interface UserService {
    void userAdd(String login) throws LoginAlreadyInUseException;

    User userShowByLogin(String login);

    User userCheckByPassword(String password);

    void userShowAll();

    void userBlock(int id);

    void userUnblock(int id);
}
