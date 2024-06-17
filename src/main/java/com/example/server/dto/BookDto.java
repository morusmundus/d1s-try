package com.example.server.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Builder
@Data
public class BookDto {
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private Long id;
    private String title;
    private int availableCopies;
    private List<String> authors;
    private List<String> genres;
    private String url;
    private Date published;
    private Double price;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean isAvailable;
}
