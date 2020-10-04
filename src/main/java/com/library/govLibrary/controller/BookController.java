package com.library.govLibrary.controller;

import com.library.govLibrary.model.Book;
import com.library.govLibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/books")
    public List<Book> getAuthors(){
        return bookService.getBooks();
    }

    @GetMapping("/book/{id}")
    public Book getAuthor(@PathVariable long id){
        return bookService.getBook(id);
    }
}
