package com.adis360.user.controller;

import com.adis360.user.dtos.CreateUserRequest;
import com.adis360.user.dtos.UserResponse;
import com.adis360.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    ResponseEntity<UserResponse> createUser(@RequestBody @Valid CreateUserRequest createUserRequest){
        return ResponseEntity
                .status(201)
                .body(userService.createUser(createUserRequest));
    }
}
