package com.library.govLibrary.controller;

import com.library.govLibrary.model.Book;
import com.library.govLibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks(@RequestParam(required = false) Integer page) {
        int pageNum = page != null && page > 1 ? page : 1;
        return bookService.getBooks(pageNum);
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
    public List<Book> getBooksContainTitle(@PathVariable String title) {
        return bookService.getBooksContainTitle(title);
    }

    @PostMapping("/book")
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @PutMapping("/book")
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable long id){
        bookService.deleteBook(id);
    }
}
