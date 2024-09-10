package com.example.securingapis.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserRegistrationController {

    private final PasswordEncoder passwordEncoder;

    public UserRegistrationController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        // Simulate saving the new user with encoded password
        String encodedPassword = passwordEncoder.encode(password);
        // In a real-world scenario, you would save the user to a database here
        return "User registered with username: " + username + " and encoded password: " + encodedPassword;
    }
}
