package com.example.server.service;

import com.example.server.entity.User;
import com.example.server.entity.UserPrincipal;
import com.example.server.exceptions.UserIsBlockedException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserPrincipalService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User entity = userService.findByEmail(username).orElseThrow();
        if (entity.isBlocked()) {
            throw new UserIsBlockedException();
        }

        return UserPrincipal.builder()
                .userId(entity.getId())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .authorities(List.of(new SimpleGrantedAuthority(String.format("ROLE_%s", entity.getRole().name()))))
                .build();
    }
}
