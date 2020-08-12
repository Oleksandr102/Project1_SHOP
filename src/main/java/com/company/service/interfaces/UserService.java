package com.company.service.interfaces;

<<<<<<< HEAD
import com.company.model.user.User;
import com.company.service.exceptions.LoginAlreadyInUseException;
=======
import com.company.authorization.exception.LoginAlreadyInUseException;
import com.company.model.user.User;
>>>>>>> c04c6916785d82eabd18e7f1589d5e5f7218c847

public interface UserService {
    void userAdd(String login) throws LoginAlreadyInUseException;

    User userShowByLogin(String login);

    User userCheckByPassword(String password);

    void userShowAll();

    void userBlock(int id);

    void userUnblock(int id);
}
