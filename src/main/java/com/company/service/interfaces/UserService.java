package com.company.service.interfaces;

import main.java.com.company.model.user.User;

public interface UserService {
    void userAdd(String login, String password);

    User userShowByLogin(String login);

    User userCheckByPassword(String password);

    void userShowAll();

    void userBlock(int id);

    void userUnblock(int id);
}
