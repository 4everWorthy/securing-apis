package com.example.securingapis.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/test")
    public String adminTest() {
        return "Admin access granted";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user/test")
    public String userTest() {
        return "User access granted";
    }

    @GetMapping("/public/test")
    public String publicTest() {
        return "Public access granted";
    }
}
