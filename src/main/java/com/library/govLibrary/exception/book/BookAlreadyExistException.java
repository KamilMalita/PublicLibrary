package com.library.govLibrary.exception.book;

public class BookAlreadyExistException extends RuntimeException {
    public BookAlreadyExistException(long id) {
        super("Book with id: " + id + " has already been created in the database.");
    }
}
