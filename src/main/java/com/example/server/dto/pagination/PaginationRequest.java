package com.example.server.dto.pagination;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaginationRequest {
    private String query;
    private int needPage;
    private int limit;
}
