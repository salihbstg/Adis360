package com.adis360.company.mapper;

import com.adis360.company.dtos.CompanyResponse;
import com.adis360.company.dtos.CreateCompanyRequest;
import com.adis360.company.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {
    public CompanyResponse toResponse(Company company) {
        return new CompanyResponse(company.getId(), company.getName());
    }

    public Company toEntity(CreateCompanyRequest createCompanyRequest) {
        Company company=new Company();
        company.setName(createCompanyRequest.name().trim());
        return company;
    }
}
