package com.example.server.repositories;

import com.example.server.entity.Book;
import com.example.server.entity.GenreRef;
import com.example.server.dto.chart.PieChartDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookRepository extends Repository<Book>, PagingAndSortingRepository<Book, Long> {

    long countByGenresIn(List<GenreRef> genres);
    long countByTitleContainingAndGenresIn(String title, List<GenreRef> genres);
    List<Book> findByGenresIn(List<GenreRef> genres, Pageable pageable);
    List<Book> findByTitleContainingAndGenresIn(String title, List<GenreRef> genres, Pageable pageable);

    @Query("SELECT new com.example.server.dto.chart.PieChartDto(g.name, COUNT(b) * 100.0 / (SELECT COUNT(b2) FROM " +
            "Book b2)) " +
            "FROM GenreRef g " +
            "LEFT JOIN g.books b " +
            "GROUP BY g.id, g.name")
    List<PieChartDto> getGenrePercentages();
}
