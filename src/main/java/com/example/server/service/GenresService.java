package com.example.server.service;

import com.example.server.entity.GenreRef;
import com.example.server.repositories.GenreRefRepository;
import com.example.server.repositories.Repository;
import org.springframework.stereotype.Service;

@Service
public class GenresService extends AbstractService<GenreRef> {
    public GenresService(Repository<GenreRef> repository) {
        super(repository);
    }

    public GenreRef findByGenreName(String name) {
        return ((GenreRefRepository) repository).findByName(name).orElseThrow();
    }
}