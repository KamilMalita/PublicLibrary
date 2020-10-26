package com.library.govLibrary.service;

import com.library.govLibrary.model.Authorities;
import com.library.govLibrary.model.Users;
import com.library.govLibrary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Users createUser(){
        Users user = new Users();
        user.setUsername("Kielbasa");
        user.setPassword("Kielbasa");
        user.setEnabled(false);
        Authorities authority = new Authorities();
        authority.setUsername("Kielbasa");
        authority.setAuthority("ADMIN");
        return userRepository.save(user);
    }
}
