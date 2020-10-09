package com.library.govLibrary.controller;

import com.library.govLibrary.controller.dto.AuthorDto;
import com.library.govLibrary.model.Author;
import com.library.govLibrary.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/authors")
    public List<AuthorDto> getAuthors(@RequestParam(required = false) int page){
        int pageNum = page > 0? page: 1;
        return AuthorDto.mapToDtos(authorService.getAuthors(pageNum - 1));
    }

    @GetMapping("/authors/{surname}")
    public List<Author> getAuthors(@PathVariable String surname){
        return authorService.getAuthors(surname);
    }

    @GetMapping("/author/{id}/book")
    public Author getAuthorWithBooks(@PathVariable long id){
        return authorService.getAuthorWithBooks(id);
    }

    @GetMapping("/author/{id}")
    public AuthorDto getAuthor(@PathVariable long id){
        return AuthorDto.mapToDto(authorService.getAuthor(id));
    }
}
