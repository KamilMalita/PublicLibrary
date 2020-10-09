package com.library.govLibrary.controller.dto;

import com.library.govLibrary.model.Author;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class AuthorDto {
    private long id;
    private String name;
    private String surname;
    private String description;
    private LocalDateTime bornDate;


    public static List<AuthorDto> mapToDtos(List<Author> authors) {
        return authors.stream().map(AuthorDto::mapToDto).collect(Collectors.toList());
    }

    public static AuthorDto mapToDto(Author author) {
        return AuthorDto.builder()
                .bornDate(author.getBornDate())
                .description(author.getDescription())
                .name(author.getName())
                .surname(author.getSurname())
                .id(author.getId())
                .build();
    }
}
