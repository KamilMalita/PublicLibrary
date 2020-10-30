package com.library.govLibrary.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Users {
    @Id
    private String username;
    private String password;
    private boolean enabled;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "username")
    private Authorities authority;
}
