package com.library.govLibrary.exception.user;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(String username) {
        super("User with username: '" + username + "' already exist in system");
    }
}
