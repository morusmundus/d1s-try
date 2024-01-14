package com.example.server.controller;

import com.example.server.entity.GenreRef;
import com.example.server.service.GenresService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class GenresController {

    private final GenresService genresService;

    @GetMapping("/genres")
    public List<GenreRef> getAll() {
        return genresService.findAll();
    }
}
