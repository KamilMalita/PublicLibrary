package com.library.govLibrary.exception.user;

public class UserBadRequestException extends RuntimeException {
    public UserBadRequestException(String message) {
        super("Bad request, message: " + message);
    }
}
