package com.company.exception;

public class LoginAlreadyInUseException extends Exception {
    public LoginAlreadyInUseException(String s) {
        super(s);
    }
}
