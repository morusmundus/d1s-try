package com.example.server.service.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;

public interface JwtService {
    String createToken(Long userId, String password, String role);
    DecodedJWT extractToken(String token);
}
