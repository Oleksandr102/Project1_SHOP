package com.company.service.interfaces;

import com.company.model.user.User;
import com.company.exception.LoginAlreadyInUseException;

public interface UserService {
    void userAdd(String login) throws LoginAlreadyInUseException;

    User userShowByLogin(String login);

    User userCheckByPassword(String password);

    void userShowAll();

    void userBlock(int id);

    void userUnblock(int id);
}
