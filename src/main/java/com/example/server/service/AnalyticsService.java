package com.example.server.service;

import com.example.server.dto.chart.PieChartDto;
import com.example.server.dto.chart.SalesAnalisysDto;
import com.example.server.repositories.BookRepository;
import com.example.server.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.List;

@Service
public class AnalyticsService {
    private final BookRepository bookRepository;
    private final OrderRepository orderRepository;

    public AnalyticsService(BookRepository bookRepository, OrderRepository orderRepository) {
        this.bookRepository = bookRepository;
        this.orderRepository = orderRepository;
    }

    public List<PieChartDto> getPieDataCategoryFraction() {
        return bookRepository.getGenrePercentages();
    }

    public List<SalesAnalisysDto> getXYZAnalisys(String date1, String date2) {
        //String s = "2020-02-13T18:51:09.840Z";
        TemporalAccessor ta = DateTimeFormatter.ISO_INSTANT.parse(date1);
        Instant instant1 = Instant.from(ta);
        Date d1 = Date.from(instant1);

        TemporalAccessor ta2 = DateTimeFormatter.ISO_INSTANT.parse(date2);
        Instant instant2 = Instant.from(ta2);
        Date d2 = Date.from(instant2);

        return orderRepository.getXYZAnalisys(d1, d2);
    }
}