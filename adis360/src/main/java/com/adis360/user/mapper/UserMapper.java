package com.adis360.user.mapper;

import com.adis360.company.entity.Company;
import com.adis360.user.dtos.CompanyResponse;
import com.adis360.user.dtos.CreateUserRequest;
import com.adis360.user.dtos.UserResponse;
import com.adis360.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(CreateUserRequest createUserRequest, Company company) {
        User user = new User();
        user.setCompany(company);
        user.setEmail(createUserRequest.email());
        user.setFullName(createUserRequest.fullName());
        user.setPasswordHash(createUserRequest.password());
        user.setRole(createUserRequest.role());
        return user;
    }

    public UserResponse toResponse(User user, CompanyResponse companyResponse) {
        return new UserResponse(
                companyResponse,
                user.getFullName(),
                user.getRole(),
                user.getPhone(),
                user.getIsActive(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
