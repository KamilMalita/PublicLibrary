package com.library.govLibrary.controller;

import com.library.govLibrary.model.Credentials;
import com.library.govLibrary.model.Users;
import com.library.govLibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/login")
    public void login(@RequestBody Credentials credentials) {
    }

    @PostMapping("/register")
    public String register(@RequestBody Users user) {
        return userService.createUser(user);
    }
}
