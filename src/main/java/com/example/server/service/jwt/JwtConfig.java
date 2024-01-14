package com.example.server.service.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Data
@Configuration
@ConfigurationProperties("token.jwt")
public class JwtConfig {
    private String secretKey;
    private Long validTime;
}
