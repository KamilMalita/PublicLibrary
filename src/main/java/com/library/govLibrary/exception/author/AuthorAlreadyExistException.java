package com.library.govLibrary.exception.author;

public class AuthorAlreadyExistException extends RuntimeException {
    public AuthorAlreadyExistException(long id) {
        super("Author with id: " + id + " has already been created in the database.");
    }
}
