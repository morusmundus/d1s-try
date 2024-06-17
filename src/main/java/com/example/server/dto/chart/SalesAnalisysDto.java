package com.example.server.dto.chart;

import lombok.Data;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Data
public class SalesAnalisysDto {

    private Long receipt_id;

    private Long book_id;

    private LocalDate creation_time;

    private Double money;

    private String title;

    public SalesAnalisysDto(Long receipt_id, Long book_id, Date creation_time, Double money, String title) {
        this.receipt_id = receipt_id;
        this.book_id = book_id;
        this.creation_time = creation_time.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.money = money;
        this.title = title;
    }
}
