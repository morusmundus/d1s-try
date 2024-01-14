package com.example.server.dto;

import lombok.Data;

@Data
public class UserChangesDto {
    private Long id;
    private String role;
    private boolean isBlocked;
}
