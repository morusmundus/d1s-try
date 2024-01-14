package com.example.server.service;

import com.example.server.entity.UserPrincipal;
import com.example.server.dto.LoginResponseDto;
import com.example.server.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public LoginResponseDto login(String email, String password) {
        Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(email, password)
        );

        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
        String role = principal.getAuthorities().toString();

        return new LoginResponseDto(jwtService.createToken(principal.getUserId(), principal.getEmail(), role),
                principal.getUserId(), role.substring(6, role.length() - 1));
    }
}
