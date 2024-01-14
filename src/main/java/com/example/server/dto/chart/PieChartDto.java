package com.example.server.dto.chart;

import lombok.Data;

@Data
public class PieChartDto {

    private String name;
    private double value;

    public PieChartDto(String name, double value) {
        this.name = name;
        this.value = value;
    }
}
