package com.example.server.service;

import com.example.server.dto.BookDto;
import com.example.server.dto.UserChangesDto;
import com.example.server.dto.UserInfoDto;
import com.example.server.dto.helpers.BookConverter;
import com.example.server.dto.helpers.PersonalInfoConverter;
import com.example.server.entity.Book;
import com.example.server.entity.GenreRef;
import com.example.server.entity.User;
import com.example.server.entity.UserPersonalInfo;
import com.example.server.repositories.BookRepository;
import com.example.server.repositories.Repository;
import com.example.server.repositories.UserInfoRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserInfoService extends AbstractService<UserPersonalInfo>{

    public UserInfoService(Repository<UserPersonalInfo> repository) {
        super(repository);
    }

   public void update(UserInfoDto dto) {
        System.out.println(dto);
        repository.findById(dto.getId()).ifPresent(u -> {
            u.setName(dto.getName());
            u.setSurname(dto.getSurname());
            u.setPatronymic(dto.getPatronymic());
            u.setAddressCity(dto.getAddressCity());
            u.setAddressStreet(dto.getAddressStreet());
            u.setAddressHouse(dto.getAddressHouse());
            u.setAddressFlat(dto.getAddressFlat());

            repository.save(u);
        });
    }
}
