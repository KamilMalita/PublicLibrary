package com.library.govLibrary.controller;

import com.library.govLibrary.controller.dto.AuthorDto;
import com.library.govLibrary.model.Author;
import com.library.govLibrary.service.AuthorService;
import com.library.govLibrary.validator.AuthorValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<Object> addAuthor(@RequestBody @Valid Author author){
        return ResponseEntity.ok(authorService.addAuthor(author));
    }

    @PutMapping("/author")
    public Author updateAuthor(@RequestBody Author author){
        return authorService.updateAuthor(author);
    }

    @DeleteMapping("/author/{id}")
    public void deleteAuthor(@PathVariable long id){
        authorService.deleteAuthor(id);
    }

    @InitBinder("author")
    protected void initBinder(WebDataBinder binder){
        binder.addValidators(new AuthorValidator());
    }

    @PostMapping("/authorrr")
    public ResponseEntity<Object> addAuthorValidate(@RequestBody @Validated Author author){
        return ResponseEntity.ok(authorService.addAuthor(author));
    }

}
