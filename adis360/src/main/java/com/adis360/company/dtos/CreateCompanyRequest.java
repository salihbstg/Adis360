package com.adis360.company.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateCompanyRequest(

        @NotBlank
        @Size(max = 150)
        String name,

        @NotBlank
        @Size(max = 50)
        String ownerName,

        @NotBlank
        @Email
        @Size(max = 50)
        String ownerEmail,

        @NotBlank
        @Size(max = 13)
        String phone,

        @NotBlank
        @Size(max = 64, min = 8)
        String password

) {
}