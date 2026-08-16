package com.ivanna.ticket.controller;

import com.ivanna.ticket.dto.CreateUserRequest;
import com.ivanna.ticket.dto.LoginRequest;
import com.ivanna.ticket.service.AuthService;
import com.ivanna.ticket.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    public AuthController(
            AuthService authService,
            UserService userService) {

        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody CreateUserRequest request){
        userService.createUser(request);
        return ResponseEntity.ok("User registered succesfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequest request){
        authService.login(request);
        return ResponseEntity.ok("Authentication succesful");
    }



}
