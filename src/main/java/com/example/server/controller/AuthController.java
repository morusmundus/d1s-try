package com.example.server.controller;

import com.example.server.dto.LoginInputDto;
import com.example.server.dto.LoginResponseDto;
import com.example.server.service.AuthService;
import com.example.server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginInputDto creds) {
        return authService.login(creds.getEmail(), creds.getPassword());
    }

    @PostMapping("/registration")
    public ResponseEntity<Object> register(@RequestBody LoginInputDto creds) {
        userService.register(creds.getEmail(), passwordEncoder.encode(creds.getPassword()));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/recovery")
    public ResponseEntity<Object> submitEmail(@RequestParam(name = "email") String email) {
        userService.recoverPassword(email);
        return ResponseEntity.ok().build();
    }
}
