package com.library.govLibrary.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
public class Address {
    @Id
    private long id;
    private String town;
    private String street;
    private String postalCode;

    @OneToMany
    @JoinColumn(name = "addressId")
    private List<Library> library;
}
