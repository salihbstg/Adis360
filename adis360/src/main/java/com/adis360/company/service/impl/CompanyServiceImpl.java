package com.adis360.company.service.impl;

import com.adis360.company.dtos.CompanyResponse;
import com.adis360.company.dtos.CreateCompanyRequest;
import com.adis360.company.entity.Company;
import com.adis360.company.mapper.CompanyMapper;
import com.adis360.company.repository.CompanyRepository;
import com.adis360.company.service.CompanyService;
import com.adis360.user.dtos.CreateUserRequest;
import com.adis360.user.enums.Role;
import com.adis360.user.repository.UserRepository;
import com.adis360.user.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final UserService userService;
    private final CompanyMapper companyMapper;

    @Override
    @Transactional
    public CompanyResponse createCompany(CreateCompanyRequest createCompanyRequest) {
        Company company=companyRepository.save(companyMapper.toEntity(createCompanyRequest));
        CreateUserRequest createUserRequest=new CreateUserRequest(
                company.getId(),
                createCompanyRequest.ownerName(),
                createCompanyRequest.ownerEmail(),
                createCompanyRequest.phone(),
                createCompanyRequest.password(),
                Role.OWNER
        );
        userService.createOwner(createUserRequest);
        return companyMapper.toResponse(company);
    }
}
