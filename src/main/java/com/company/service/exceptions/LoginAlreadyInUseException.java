package com.company.service.exceptions;

public class LoginAlreadyInUseException extends Exception {
    public LoginAlreadyInUseException(String message) {
        super(message);
    }
}
