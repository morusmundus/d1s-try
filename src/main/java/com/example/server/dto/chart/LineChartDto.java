package com.example.server.dto.chart;

import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Data
public class LineChartDto {

    private LocalDate date;
    private Long quantity;

    public LineChartDto(Date date, Long quantity) {
            this.date = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.quantity = quantity;
    }
}
