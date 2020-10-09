package com.library.govLibrary.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Author {
    @Id
    private long id;
    private String name;
    private String surname;
    private String description;
    private LocalDateTime bornDate;

    @OneToMany
    @JoinColumn(name = "authorId")
    private List<Book> book;
}
