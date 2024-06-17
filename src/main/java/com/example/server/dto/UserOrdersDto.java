package com.example.server.dto;

import lombok.Builder;
import lombok.Data;

import java.time.ZoneId;
import java.util.Date;

@Builder
@Data
public class UserOrdersDto {
    private Long receipt_id;
    private Long book_id;
    private Long user_id;
    private Date creation_time;
    private Integer quantity;
    private String title;
    private Double price;

}
