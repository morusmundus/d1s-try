package com.example.server.controller;

import com.example.server.dto.BookDto;
import com.example.server.dto.pagination.PaginationResponse;
import com.example.server.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/books")
    public PaginationResponse getAll(
            @RequestParam(name = "limit") int limit,
            @RequestParam(name = "needPage") int page,
            @RequestParam(name = "query", required = false, defaultValue = "") String query,
            @RequestParam(name = "filter", required = false, defaultValue = "0") Long filterId

    ) {
        return bookService.findAllModels(query, page, limit, filterId);
    }

    @PostMapping("/librarian/books")
    public Object createBook(@RequestBody BookDto dto) {
        bookService.createBook(dto);
        return ResponseEntity.accepted().build();
    }
}
