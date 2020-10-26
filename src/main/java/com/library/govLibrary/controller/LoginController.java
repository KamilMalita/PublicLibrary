package com.library.govLibrary.controller;

import com.library.govLibrary.model.Credentials;
import com.library.govLibrary.model.Users;
import com.library.govLibrary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;

    @PostMapping("/login")
    public void login(@RequestBody Credentials credentials) {
    }

    @GetMapping("/register")
    public Users register() {
        return userService.createUser();
    }
}
