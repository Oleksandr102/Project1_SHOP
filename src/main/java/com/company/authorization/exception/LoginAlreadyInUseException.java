package com.company.authorization.exception;

public class LoginAlreadyInUseException extends Exception {
    public LoginAlreadyInUseException(String s) {
        super(s);
    }
}
