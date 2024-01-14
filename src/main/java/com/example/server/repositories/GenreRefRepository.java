package com.example.server.repositories;

import com.example.server.entity.GenreRef;

import java.util.Optional;

public interface GenreRefRepository extends Repository<GenreRef> {
    Optional<GenreRef> findByName(String name);
}
