package com.adis360.user.service;

import com.adis360.user.dtos.CreateUserRequest;
import com.adis360.user.dtos.UserResponse;

import java.util.UUID;

public interface UserService {
    UserResponse createUser(CreateUserRequest createUserRequest);

    void createOwner(CreateUserRequest createUserRequest);
}
