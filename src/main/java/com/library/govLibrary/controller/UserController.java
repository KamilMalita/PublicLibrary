package com.library.govLibrary.controller;

import com.library.govLibrary.model.Credentials;
import com.library.govLibrary.model.Users;
import com.library.govLibrary.service.UserService;
import com.library.govLibrary.validation.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public void login(@RequestBody Credentials credentials) {
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody Users user) {
        return ResponseEntity.ok(userService.createUser(user));
    }
}
