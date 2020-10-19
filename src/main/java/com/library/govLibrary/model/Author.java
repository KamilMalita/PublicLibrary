package com.library.govLibrary.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private String description;
    private LocalDateTime bornDate;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "authorId", updatable = false, insertable = false)
    private List<Book> book;
}
