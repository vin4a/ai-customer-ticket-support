package com.ivanna.ticket.service;

import com.ivanna.ticket.dto.CreateUserRequest;
import com.ivanna.ticket.model.User;
import com.ivanna.ticket.model.UserRole;
import com.ivanna.ticket.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository; //guardar al usuario
    private final PasswordEncoder passwordEncoder; //cifrarlo antes

    public UserService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(CreateUserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(UserRole.USER);

        return userRepository.save(user);
    }
}
