package com.onlinexamportal.examportal.controller;

import com.onlinexamportal.examportal.dto.LoginRequest;
import com.onlinexamportal.examportal.dto.RegisterRequest;
import com.onlinexamportal.examportal.dto.UserResponse;
import com.onlinexamportal.examportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest request) {
        System.out.println("Received request: " + request.getEmail());
        return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(userService.login(request));
    }
}
