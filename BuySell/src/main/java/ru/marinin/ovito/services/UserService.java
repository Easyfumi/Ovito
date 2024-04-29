package ru.marinin.ovito.services;

import lombok.RequiredArgsConstructor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.marinin.ovito.models.User;
import ru.marinin.ovito.models.enums.Role;
import ru.marinin.ovito.repository.UserRepository;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(User user) {
        String email = user.getEmail();
        if (userRepository.findByEmail(email)!=null) {
            return false;
        } else {
            user.setActive(true);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.getRoles().add(Role.ROLE_USER);
            log.info("Saving new user with email: {}", email);
            userRepository.save(user);
            return true;
        }
    }
}
