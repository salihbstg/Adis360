package com.adis360.user.service.impl;

import com.adis360.company.entity.Company;
import com.adis360.company.repository.CompanyRepository;
import com.adis360.exception.OwnerRoleNotAllowedException;
import com.adis360.user.dtos.CompanyResponse;
import com.adis360.user.dtos.CreateUserRequest;
import com.adis360.user.dtos.UserResponse;
import com.adis360.user.entity.User;
import com.adis360.user.enums.Role;
import com.adis360.user.mapper.UserMapper;
import com.adis360.user.repository.UserRepository;
import com.adis360.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final CompanyRepository companyRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse createUser(CreateUserRequest request) {

        if (request.role() == null) {
            throw new IllegalArgumentException(
                    "Geçerli bir çalışan rolü seçilmelidir"
            );
        }
        if(request.role() == Role.OWNER){
            throw new OwnerRoleNotAllowedException("İşletme sahibi rolü mevcuttur, farklı bir hesaba atanamaz!");
        }

        User savedUser = createAndSaveUser(request, request.role());

        Company company = savedUser.getCompany();

        return userMapper.toResponse(
                savedUser,
                new CompanyResponse(company.getId(), company.getName())
        );
    }

    @Override
    public void createOwner(CreateUserRequest request) {
        createAndSaveUser(request, Role.OWNER);
    }

    private User createAndSaveUser(CreateUserRequest request, Role role) {

        Company company = companyRepository.findById(request.companyId())
                .orElseThrow();

        User user = userMapper.toEntity(request, company);

        user.setPasswordHash(
                passwordEncoder.encode(request.password())
        );

        user.setRole(role);
        user.setPhone(request.phone());

        return userRepository.save(user);
    }
}