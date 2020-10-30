package com.library.govLibrary.service;

import com.library.govLibrary.exception.user.UserAlreadyExistException;
import com.library.govLibrary.exception.user.UserBadRequestException;
import com.library.govLibrary.model.Authorities;
import com.library.govLibrary.model.Users;
import com.library.govLibrary.repository.AuthoritiesRepository;
import com.library.govLibrary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        try {
            user.setAuthority(null);
            Optional<Users> optionalUser = userRepository.findById(user.getUsername());
            if (optionalUser.isPresent()) throw new UserAlreadyExistException(user.getUsername());

            user.setPassword("{bcrypt}" + new BCryptPasswordEncoder().encode(user.getPassword()));

            userRepository.save(user);

            Authorities authorities = new Authorities();
            authorities.setUsername(user.getUsername());
            authorities.setAuthority("ROLE_USER");
            authoritiesRepository.save(authorities);

            return "User: " + user.getUsername() + " has been created";
        } catch (Exception e) {
            throw new UserBadRequestException(e.getMessage());
        }
    }
}
