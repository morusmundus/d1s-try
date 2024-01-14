package com.example.server.repositories;

import com.example.server.entity.User;

import java.util.Optional;

public interface UserRepository extends Repository<User> {
   Optional<User> findByEmail(String email);
}
