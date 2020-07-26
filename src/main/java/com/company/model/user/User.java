package com.company.model.user;

import com.company.model.user.enums.Rights;
import com.company.model.user.enums.Status;

import java.util.Objects;

import static com.company.dao.users.UsersList.users;

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
