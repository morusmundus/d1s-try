package com.example.server.dto.helpers;

import com.example.server.entity.Book;
import com.example.server.entity.GenreRef;
import com.example.server.dto.BookDto;

import java.text.SimpleDateFormat;
import java.util.List;

public class BookConverter {
    public static BookDto convert(Book book) {
        List<String> authors = book.getAuthors().stream()
                .map(b -> String.format("%s %s. %s.", b.getSName(), b.getFName().charAt(0), b.getTName().charAt(0)))
                .toList();

        List<String> genres = book.getGenres().stream()
                .map(GenreRef::getName)
                .toList();

        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .availableCopies(book.getCopiesCount())
                .authors(authors)
                .published(book.getPublished())
                .genres(genres)
                .url(book.getUrl())
                .isAvailable(book.getCopiesCount() > 0)
                .price(book.getPrice())
                .build();
    }
}
