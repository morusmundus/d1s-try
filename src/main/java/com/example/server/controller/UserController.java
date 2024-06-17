package com.example.server.controller;

import com.example.server.dto.UserChangesDto;
import com.example.server.dto.UserInfoDto;
import com.example.server.entity.User;
import com.example.server.entity.UserPersonalInfo;
import com.example.server.entity.UserPrincipal;
import com.example.server.service.UserInfoService;
import com.example.server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserInfoService userInfoService;

    @GetMapping("/user")
    public User getAuthUser(@AuthenticationPrincipal UserPrincipal user) {
        return userService.findById(user.getUserId()).get();
    }

    @GetMapping("/users")
    public Object getUsers() {
        return userService.findAll();
    }

    @PutMapping("/users")
    public Object changeUserParams(@RequestBody UserChangesDto changesDto) {
        userService.update(changesDto);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/user-personal-infos")
    public Object getAllUserInfo() {
        System.out.println(userInfoService.findAll());
        return userInfoService.findAll();
    }

    @GetMapping("/user-personal-info")
    public Object getUserInfo(@AuthenticationPrincipal UserPrincipal user) {
        return userInfoService.findById(user.getUserId());
        // return userService.findById(user.getUserId()).get();
    }

    @PutMapping("/user-personal-info")
    public Object changeUserInfoParams(@RequestBody UserInfoDto changesDto) {
        userInfoService.update(changesDto);
        return ResponseEntity.accepted().build();
    }

}
