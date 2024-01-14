package com.example.server.dto.pagination;

import com.example.server.dto.BookDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PaginationResponse {
    private long total;
    private int current;
    private List<BookDto> books;
}
