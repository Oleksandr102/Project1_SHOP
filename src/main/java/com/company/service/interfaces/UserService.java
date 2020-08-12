package com.company.service.interfaces;

import com.company.model.user.User;
import com.company.service.exceptions.LoginAlreadyInUseException;

public interface UserService {
    void userAdd(String login, String password) throws LoginAlreadyInUseException;

    User userShowByLogin(String login);

    User userCheckByPassword(String password);

    void userShowAll();

    void userBlock(int id);

    void userUnblock(int id);
}
