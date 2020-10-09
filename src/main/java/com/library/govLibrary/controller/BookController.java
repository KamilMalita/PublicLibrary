package com.library.govLibrary.controller;

import com.library.govLibrary.model.Book;
import com.library.govLibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/books")
    public List<Book> getAuthors(@RequestParam int page) {
        return bookService.getBooks(page);
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable long id) {
        return bookService.getBook(id);
    }

    @GetMapping("/books/author/{id}")
    public List<Book> getBooksForAuthor(@PathVariable long id) {
        return bookService.getBooksForAuthor(id);
    }

    @GetMapping("/books/{title}")
    public List<Book> getBooksContainTitle(@PathVariable String title){
        return bookService.getBooksContainTitle(title);
    }
}
