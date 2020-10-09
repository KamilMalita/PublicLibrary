package com.library.govLibrary.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Book {
    @Id
    private long id;
    private String title;
    private String description;
    private LocalDateTime releaseDate;
    private long authorId;
}
