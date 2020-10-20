package com.library.govLibrary.service;

import com.library.govLibrary.exception.author.AuthorAlreadyExistException;
import com.library.govLibrary.exception.author.AuthorNotFoundException;
import com.library.govLibrary.exception.book.BookAlreadyExistException;
import com.library.govLibrary.exception.book.BookNotFoundException;
import com.library.govLibrary.model.Book;
import com.library.govLibrary.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
        return bookRepository.findByAuthorId(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    public List<Book> getBooksForAuthor(long id) {
        return bookRepository.findAllBooksForAuthor(id);
    }

    public Book addBook(Book book) {
        if (bookRepository.existsById(book.getId()))
            throw new BookAlreadyExistException(book.getId());
        return bookRepository.save(book);
    }

    @Transactional
    public Book updateBook(Book book) {
        Book bookEditable = bookRepository.findByAuthorId(book.getId()).orElseThrow(() -> new BookNotFoundException(book.getId()));
        if (book.getAuthorId() > 0)
            bookEditable.setAuthorId(book.getAuthorId());
        if (book.getDescription() != null)
            bookEditable.setDescription(book.getDescription());
        if (book.getTitle() != null)
            bookEditable.setTitle(book.getTitle());
        if (book.getReleaseDate() != null)
            bookEditable.setReleaseDate(book.getReleaseDate());
        return bookRepository.save(bookEditable);
    }

    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }
}
