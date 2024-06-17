package com.example.server.dto.helpers;

import com.example.server.dto.BookDto;
import com.example.server.dto.UserInfoDto;
import com.example.server.entity.Book;
import com.example.server.entity.GenreRef;
import com.example.server.entity.UserPersonalInfo;

import java.util.List;

public class PersonalInfoConverter {
    public static UserInfoDto convert(UserPersonalInfo userPI) {
//        List<String> authors = book.getAuthors().stream()
//                .map(b -> String.format("%s %s. %s.", b.getSName(), b.getFName().charAt(0), b.getTName().charAt(0)))
//                .toList();
//
//        List<String> genres = book.getGenres().stream()
//                .map(GenreRef::getName)
//                .toList();

        return UserInfoDto.builder()
                .name(userPI.getName())
                .surname(userPI.getSurname())
                .patronymic(userPI.getPatronymic())
                .addressCity(userPI.getAddressCity())
                .addressStreet(userPI.getAddressStreet())
                .addressHouse(userPI.getAddressHouse())
                .addressFlat(userPI.getAddressFlat())
                .build();
    }
}
