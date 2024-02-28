package com.mate.onlinebookstore.onlinebookstore.exception;

import org.springframework.http.HttpStatus;

public class RegistrationException extends RuntimeException {
    public RegistrationException(String message) {
        super(message);
    }
}
