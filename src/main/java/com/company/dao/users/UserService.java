package main.java.com.company.dao.users;

public interface UserService {
    void userAdd(String login, String password);
    void userShowByLogin(String login);
    void userShowAll();
    void userBlock(int id);
    void userUnblock(int id);
}
