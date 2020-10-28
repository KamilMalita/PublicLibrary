package com.library.govLibrary.service;

import com.library.govLibrary.exception.user.UserAlreadyExistException;
import com.library.govLibrary.model.Authorities;
import com.library.govLibrary.model.Users;
import com.library.govLibrary.repository.AuthoritiesRepository;
import com.library.govLibrary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AuthoritiesRepository authoritiesRepository;

    @Transactional
    public String createUser(Users user) {
        user.setAuthority(null);
        Optional<Users> optionalUser = userRepository.findById(user.getUsername());
        if (optionalUser.isPresent()) throw new UserAlreadyExistException(user.getUsername());

        userRepository.save(user);

        Authorities authorities = new Authorities();
        authorities.setUsername(user.getUsername());
        authorities.setAuthority("ROLE_USER");
        authoritiesRepository.save(authorities);

        return "User: " + user.getUsername() + " has been created";
    }
}
