package com.example.server.service;

import com.example.server.dto.chart.PieChartDto;
import com.example.server.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyticsService {

    private final BookRepository bookRepository;

    public AnalyticsService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<PieChartDto> getPieDataCategoryFraction() {
        return bookRepository.getGenrePercentages();
    }
}