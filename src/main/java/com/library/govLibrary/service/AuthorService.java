package com.library.govLibrary.service;

import com.library.govLibrary.model.Author;
import com.library.govLibrary.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }

    public Author getAuthor(long id){
        return authorRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
