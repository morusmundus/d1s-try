package com.example.server.service.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService{

    private final JwtConfig jwtConfig;

    @Override
    public String createToken(Long userId, String email, String role) {
        return JWT.create()
                .withSubject(String.valueOf(userId))
                .withClaim("email", email)
                .withClaim("a", role)
                .withExpiresAt(Instant.now().plus(jwtConfig.getValidTime(), ChronoUnit.SECONDS))
                .sign(Algorithm.HMAC256(jwtConfig.getSecretKey()));
    }

    @Override
    public DecodedJWT extractToken(String token) {
        return JWT.require(Algorithm.HMAC256(jwtConfig.getSecretKey()))
                .build()
                .verify(token);
    }
}
