package main.java.com.company.model.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import main.java.com.company.model.user.enums.Rights;
import main.java.com.company.model.user.enums.Status;

import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private Rights rights = Rights.USER;
    private Status status = Status.ACTIVE;
    private String login;
    private String password;
    private int id;

    public User(String login, String password, Rights rights) {
        this.login = login;
        this.password = password;
        this.rights = rights;
        this.id = (int) Math.abs(Math.random() * 1000000);
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.id = (int) Math.abs(Math.random() * 1000000);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                getRights() == user.getRights() &&
                getStatus() == user.getStatus() &&
                getLogin().equals(user.getLogin()) &&
                getPassword().equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRights(), getStatus(), getLogin(), getPassword(), getId());
    }
}
