package com.adis360.company.controller;

import com.adis360.company.dtos.CompanyResponse;
import com.adis360.company.dtos.CreateCompanyRequest;
import com.adis360.company.service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/company")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    ResponseEntity<CompanyResponse> createCompany(@RequestBody @Valid CreateCompanyRequest createCompanyRequest){
        return ResponseEntity
                .status(201)
                .body(companyService.createCompany(createCompanyRequest));
    }

}
