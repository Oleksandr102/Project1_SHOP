package main.java.com.company.model;

import java.util.Objects;

import static main.java.com.company.dao.users.UsersList.users;

enum Rights {
    USER,
    ADMIN
}

enum Status {
    ACTIVE,
    BLOCKED
}

public class Users {
    private Rights rights = Rights.USER;
    private Status status = Status.ACTIVE;
    private String login;
    private String password;
    private String name;
    private String seName;

    public Users(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public Users(String login, String password, String name, String seName) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.seName = seName;
    }

    private void blockUser(String login) {
        users.stream()
                .filter(users -> users.getLogin().equals(login))
                .forEach(users -> users.setStatus(Status.BLOCKED));
    }

    private void unblockUser(String login) {
        users.stream()
                .filter(users -> users.getLogin().equals(login))
                .forEach(users -> users.setStatus(Status.ACTIVE));
    }

    public Rights getRights() {
        return rights;
    }

    public void setRights(Rights rights) {
        this.rights = rights;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeName() {
        return seName;
    }

    public void setSeName(String seName) {
        this.seName = seName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return getRights() == users.getRights() &&
                getStatus() == users.getStatus() &&
                getLogin().equals(users.getLogin()) &&
                getPassword().equals(users.getPassword()) &&
                getName().equals(users.getName()) &&
                Objects.equals(getSeName(), users.getSeName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRights(), getStatus(), getLogin(), getPassword(), getName(), getSeName());
    }


}
