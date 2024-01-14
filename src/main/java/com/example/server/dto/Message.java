package com.example.server.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {
    private String receiver;
    private String subject;
    private String message;
}
