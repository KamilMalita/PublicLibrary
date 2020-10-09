package com.library.govLibrary.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class Address {
    @Id
    private long id;
    private String town;
    private String street;
    private String postalCode;
}
