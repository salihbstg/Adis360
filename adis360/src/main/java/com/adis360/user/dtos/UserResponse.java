package com.adis360.user.dtos;

import com.adis360.user.enums.Role;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Instant;

public record UserResponse(

        @NotNull
        @Valid
        CompanyResponse companyResponse,

        @NotBlank
        @Size(max = 50)
        String fullName,

        @NotNull
        Role role,

        @NotNull
        String phone,

        @NotNull
        Boolean isActive,

        @NotNull
        Instant createdAt,

        @NotNull
        Instant updatedAt
) {
}