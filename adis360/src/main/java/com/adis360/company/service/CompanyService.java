package com.adis360.company.service;

import com.adis360.company.dtos.CompanyResponse;
import com.adis360.company.dtos.CreateCompanyRequest;

public interface CompanyService {
    CompanyResponse createCompany(CreateCompanyRequest createCompanyRequest);
}
