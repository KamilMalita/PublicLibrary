package com.library.govLibrary.service;

import com.library.govLibrary.model.Book;
import com.library.govLibrary.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BookService {
    public static final int SIZE = 20;
    private final BookRepository bookRepository;

    public List<Book> getBooks(int page) {
        return bookRepository.findAllBooks(PageRequest.of(page, SIZE));
    }

    public List<Book> getBooksContainTitle(String title) {
        return bookRepository.findAllContainTitle(title);
    }

    public Book getBook(long id) {
        return bookRepository.findByAuthorId(id).orElseThrow();
    }

    public List<Book> getBooksForAuthor(long id) {
        return bookRepository.findAllBooksForAuthor(id);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    public Book updateBook(Book book) {
        Book bookEditable = bookRepository.findByAuthorId(book.getId()).orElseThrow();
        if (book.getAuthorId() < 1)
            bookEditable.setAuthorId(book.getAuthorId());
        if(book.getDescription() != null)
            bookEditable.setDescription(book.getDescription());
        if(book.getTitle() != null)
            bookEditable.setTitle(book.getTitle());
        if(book.getReleaseDate() != null)
            bookEditable.setReleaseDate(book.getReleaseDate());
        return bookRepository.save(book);
    }
}
