package com.library.govLibrary.controller;

import com.library.govLibrary.model.Author;
import com.library.govLibrary.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/authors")
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }

    @GetMapping("/authors/{surname}")
    public List<Author> getAuthors(@PathVariable String surname){
        return authorService.getAuthors(surname);
    }

    @GetMapping("/author/{id}")
    public Author getAuthor(@PathVariable long id){
        return authorService.getAuthor(id);
    }
}
