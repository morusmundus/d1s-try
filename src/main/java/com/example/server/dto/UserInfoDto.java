package com.example.server.dto;

import com.example.server.entity.User;
import lombok.Builder;
import lombok.Data;

import java.time.ZoneId;
import java.util.Date;

@Builder
@Data
public class UserInfoDto {
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private String addressCity;
    private String addressStreet;
    private String addressHouse;
    private String addressFlat;

}
