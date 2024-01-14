package com.example.server.controller;

import com.example.server.dto.UserChangesDto;
import com.example.server.entity.User;
import com.example.server.entity.UserPrincipal;
import com.example.server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

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

//    @PutMapping("/users")
//    public Object changeUserParams(@RequestBody Map<String, Object> params) {
//        System.out.println(params);
//        //        userService.update(changesDto);
//        return ResponseEntity.accepted().build();
//    }
}
