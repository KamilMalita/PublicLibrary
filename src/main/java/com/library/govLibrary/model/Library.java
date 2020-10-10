package com.library.govLibrary.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Library {
    @Id
    private long id;
    private long addressId;
    private String libraryName;
    private String libraryDetails;
}
