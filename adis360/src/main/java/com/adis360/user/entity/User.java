package com.adis360.user.entity;

import com.adis360.company.entity.Company;
import com.adis360.user.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "company_id",nullable = false)
    private Company company;

    @Column(nullable = false,length = 50)
    private String fullName;

    @Column(nullable = false,length = 50)
    private String email;

    @Column(nullable = false,length = 13)
    private String phone;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = false,length = 64 )
    private String passwordHash;

    private Boolean isActive;

    @Column(nullable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant updatedAt;


    @PrePersist
    public void prePersist(){
        Instant now=Instant.now();
        this.createdAt=now;
        this.updatedAt=now;
        this.isActive=true;
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedAt=Instant.now();
    }
}
