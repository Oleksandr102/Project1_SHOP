package com.company.service.interfaces;

import com.company.exception.LoginAlreadyInUseException;
import com.company.model.user.User;

public interface UserService {
    void userAdd(String login) throws LoginAlreadyInUseException;

    User userShowByLogin(String login);

    User userCheckByPassword(String password);

    void userShowAll();

    void userBlock(int id);

    void userUnblock(int id);
}
