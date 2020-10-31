package com.library.govLibrary.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Entity
public class Users {
    @NotBlank
    @Id
    private String username;
    @NotEmpty
    @NotBlank
    private String password;
    private boolean enabled;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "username")
    private Authorities authority;
}
