package com.example.server.service.jwt;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.server.entity.UserPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class JwtToPrincipalConverter {

    public UserPrincipal convert(DecodedJWT jwt) {
        var authorityList = getClaimOrEmptyList(jwt).stream()
                .map(SimpleGrantedAuthority::new)
                .toList();

        return UserPrincipal.builder()
                .userId(Long.valueOf(jwt.getSubject()))
                .email(String.valueOf(jwt.getClaim("email")))
                .authorities(authorityList)
                .build();
    }

    private Set<String> getClaimOrEmptyList(DecodedJWT jwt) {
        Claim roles = jwt.getClaim("a");
        if (roles.isMissing() || roles.isNull()) return Set.of();
        return new HashSet<>(List.of(extractRole(roles.toString())));
    }

    private String extractRole(String role) {
        return role.substring(2,role.length() - 2);
    }
}
