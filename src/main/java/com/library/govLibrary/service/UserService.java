package com.library.govLibrary.service;

import com.library.govLibrary.model.Authorities;
import com.library.govLibrary.model.Users;
import com.library.govLibrary.repository.AuthoritiesRepository;
import com.library.govLibrary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AuthoritiesRepository authoritiesRepository;

    @Transactional
    public Users createUser(Users user){
        Authorities authorities = user.getAuthority();
        user.setAuthority(null);
        Users saved_user = userRepository.save(user);
        authoritiesRepository.save(authorities);
        return saved_user;
    }
}
