package com.example.server.service;

import com.example.server.entity.AuthorsRef;
import com.example.server.entity.Book;
import com.example.server.entity.GenreRef;
import com.example.server.dto.BookDto;
import com.example.server.dto.helpers.BookConverter;
import com.example.server.dto.pagination.PaginationResponse;
import com.example.server.repositories.BookRepository;
import com.example.server.repositories.Repository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService extends AbstractService<Book> {

    private static final int ALL_CATEGORIES_ID = 7;

    private final GenresService genresService;
    private final AuthorService authorService;

    public BookService(Repository<Book> repository, GenresService genresService, AuthorService authorService) {
        super(repository);
        this.genresService = genresService;
        this.authorService = authorService;
    }

    public PaginationResponse findAllModels(String query, int needPage, int limit, Long filterId) {
        BookRepository bookRepo = (BookRepository) repository;

        List<GenreRef> genres = getGenresByFilter(filterId);
        long totalRows = getTotalRowsBySearch(query.toLowerCase(), bookRepo, genres);
        List<BookDto> bookDtos =
                getBookModels(query.toLowerCase(), genres, PageRequest.of(needPage, limit), bookRepo);

        return PaginationResponse.builder()
                .total(totalRows)
                .books(bookDtos)
                .build();
    }

    private List<GenreRef> getGenresByFilter(Long filterId) {
        if (filterId == null || filterId == 0 || filterId == ALL_CATEGORIES_ID) {
            return genresService.findAll();
        } else {
            return List.of(genresService.findById(filterId).get());
        }
    }

    public void decreaseQuantity(Long bookId, int decreaseQuantity) {
        repository.findById(bookId).ifPresent(b -> {
            b.setCopiesCount(b.getCopiesCount() - decreaseQuantity);
            repository.save(b);
        });
    }

    private long getTotalRowsBySearch(String query, BookRepository bookRepo, List<GenreRef> genres) {
        if (query != null && !query.isBlank()) {
            return bookRepo.countByTitleContainingAndGenresIn(query.toLowerCase(), genres);
        } else {
           return bookRepo.countByGenresIn(genres);
        }
    }

    private List<BookDto> getBookModels(String queryLower, List<GenreRef> genres, Pageable pageable,
                                        BookRepository bookRepo) {
        List<Book> books = null;
        if (queryLower != null && !queryLower.isBlank()) {
            books = bookRepo.findByTitleContainingAndGenresIn(queryLower, genres, pageable);
        } else {
            books = bookRepo.findByGenresIn(genres, pageable);
        }
        return books.stream().map(BookConverter::convert).toList();
    }

    public void createBook(BookDto dto) {
        List<AuthorsRef> authors = dto.getAuthors().stream().map(authorService::findByAuthorFIO).toList();

        List<GenreRef> genres = dto.getGenres().stream().map(genresService::findByGenreName).toList();
        Book book = Book.builder()
                .title(dto.getTitle())
                .copiesCount(dto.getAvailableCopies())
                .published(dto.getPublished())
                .authors(authors)
                .url(dto.getUrl())
                .genres(genres)
                .build();

        repository.save(book);
    }
}