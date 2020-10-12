package com.library.govLibrary.service;

import com.library.govLibrary.model.Author;
import com.library.govLibrary.model.Book;
import com.library.govLibrary.repository.AuthorRepository;
import com.library.govLibrary.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService {
    public static final int SIZE = 20;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public List<Author> getAuthors(int page){
        return authorRepository.findAllAuthors(PageRequest.of(page, SIZE));
    }

    public List<Author> getAuthorsWithBooks(int page){
        List<Author> authorList = authorRepository.findAllAuthors(PageRequest.of(page, SIZE));
        List<Long> listAuthorId = authorList.stream().map(author -> author.getId()).collect(Collectors.toList());
        List<Book> bookList = bookRepository.findAllByAuthorIdIn(listAuthorId);
        authorList.forEach(author -> author.setBook(extractBooks(bookList, author.getId())));
        return authorList;
    }

    private List<Book> extractBooks(List<Book> bookList, long id) {
        return bookList.stream().filter(book -> book.getAuthorId() == id).collect(Collectors.toList());
    }

    public List<Author> getAuthorsWithSurname(String surname){
        return authorRepository.findAllAuthorsBySurname(surname);
    }

    public Author getAuthorWithBooks(long id){
        return authorRepository.findByIdWithBooks(id).orElseThrow(NoSuchElementException::new);
    }

    public Author getAuthor(long id) {
        return authorRepository.findById(id).orElseThrow();
    }
}
