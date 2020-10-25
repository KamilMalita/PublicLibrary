package com.library.govLibrary.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Users {
    @Id
    String username;
    String password;
    boolean enabled;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "username", updatable = false, insertable = false)
    private Authorities authority;
}
