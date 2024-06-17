package com.example.server.repositories;

import com.example.server.entity.User;
import com.example.server.entity.UserPersonalInfo;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserInfoRepository extends Repository<UserPersonalInfo>{

//    @Query("SELECT upi FROM UserPersonalInfo upi WHERE upi.user = :id")
//    List<UserPersonalInfo> findByUserId(Long id);
}
