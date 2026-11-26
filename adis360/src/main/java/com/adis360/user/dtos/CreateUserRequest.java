package com.adis360.user.dtos;

import com.adis360.user.enums.Role;
import jakarta.validation.constraints.*;

import java.util.UUID;

public record CreateUserRequest(

        @NotNull
        UUID companyId,

        @NotBlank
        @Size(max = 50)
        String fullName,

        @NotBlank
        @Email
        @Size(max = 50)
        String email,

        @NotBlank
        @Size(max = 17)
        @Pattern(
                regexp = "^(?:05\\d{9}|\\+905\\d{9}|05\\d{2} \\d{3} \\d{4}|\\+905\\d{2} \\d{3} \\d{4})$",
                message = "Geçerli bir cep telefonu numarası giriniz"
        )
        String phone,

        @NotBlank
        @Size(min = 8)
        String password,

        @NotNull
        Role role

) {
}