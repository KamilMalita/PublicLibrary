package com.library.govLibrary.service;

import com.library.govLibrary.model.Book;
import com.library.govLibrary.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Book getBook(long id){
        return bookRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
