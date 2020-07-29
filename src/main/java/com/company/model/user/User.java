package main.java.com.company.model.user;

import com.company.model.user.enums.Rights;
import com.company.model.user.enums.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

import static com.company.dao.users.UsersList.users;

@Getter
@Setter
@ToString
public class User {
    private Rights rights = Rights.USER;
    private Status status = Status.ACTIVE;
    private String login;
    private String password;
    private String name;
    private String seName;

    public User(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public User(String login, String password, String name, String seName) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.seName = seName;
    }

    private void blockUser(String login) {
        users.stream()
                .filter(user -> user.getLogin().equals(login))
                .forEach(user -> user.setStatus(Status.BLOCKED));
    }

    private void unblockUser(String login) {
        users.stream()
                .filter(user -> user.getLogin().equals(login))
                .forEach(user -> user.setStatus(Status.ACTIVE));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getRights() == user.getRights() &&
                getStatus() == user.getStatus() &&
                getLogin().equals(user.getLogin()) &&
                getPassword().equals(user.getPassword()) &&
                getName().equals(user.getName()) &&
                Objects.equals(getSeName(), user.getSeName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRights(), getStatus(), getLogin(), getPassword(), getName(), getSeName());
    }
}
