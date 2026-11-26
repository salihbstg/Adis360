package com.adis360.company.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record CompanyResponse(
        @NotNull
        UUID id,

        @NotBlank
        @Size(max = 150)
        String name
) {
}