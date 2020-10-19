package com.library.govLibrary.controller;

import com.library.govLibrary.controller.dto.AuthorDto;
import com.library.govLibrary.model.Author;
import com.library.govLibrary.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/authors")
    public List<AuthorDto> getAuthors(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNum = page != null && page > 0 ? page : 1;
        Sort.Direction sortDirection = sort != null ? sort : Sort.DEFAULT_DIRECTION;
        return AuthorDto.mapToDtos(authorService.getAuthors(pageNum - 1, sortDirection));
    }

    @GetMapping("/authors/comments")
    public List<Author> getAuthorsWithBooks(@RequestParam(required = false) Integer page, Sort.Direction sort) {
        int pageNum = page != null && page > 0 ? page : 1;
        Sort.Direction sortDirection = sort != null ? sort : Sort.DEFAULT_DIRECTION;
        return authorService.getAuthorsWithBooks(pageNum - 1, sortDirection);
    }

    @GetMapping("/authors/{surname}")
    public List<Author> getAuthors(@PathVariable String surname) {
        return authorService.getAuthorsWithSurname(surname);
    }

    @GetMapping("/author/{id}/book")
    public Author getAuthorWithBooks(@PathVariable long id) {
        return authorService.getAuthorWithBooks(id);
    }

    @GetMapping("/author/{id}")
    public AuthorDto getAuthor(@PathVariable long id) {
        return AuthorDto.mapToDto(authorService.getAuthor(id));
    }

    @PostMapping("/author")
    public Author addAuthor(@RequestBody Author author){
        return authorService.addAuthor(author);
    }

    @PutMapping("/author")
    public Author updateAuthor(@RequestBody Author author){
        return authorService.updateAuthor(author);
    }

    @DeleteMapping("/author/{id}")
    public void deleteAuthor(@PathVariable long id){
        authorService.deleteAuthor(id);
    }
}
