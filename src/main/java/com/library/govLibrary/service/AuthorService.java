package com.library.govLibrary.service;

import com.library.govLibrary.model.Author;
import com.library.govLibrary.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AuthorService {
    public static final int SIZE = 20;
    private final AuthorRepository authorRepository;

    public List<Author> getAuthors(int page){
        return authorRepository.findAllAuthors(PageRequest.of(page, SIZE));
    }

    public List<Author> getAuthors(String surname){
        return authorRepository.findAllAuthorsBySurname(surname);
    }

    public Author getAuthorWithBooks(long id){
        return authorRepository.findByIdWithBooks(id).orElseThrow(NoSuchElementException::new);
    }

    public Author getAuthor(long id) {
        return authorRepository.findById(id).orElseThrow();
    }
}
