package com.kooketplace.clone.domain.user.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * PackageName : com.kooketplace.clone.user.domain
 * FileName : User
 * Author : Koorung
 * Date : 2022년 11월 22일
 * Description : 유저 엔티티 클래스
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @EmbeddedId
    private UserId userId;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String name;

    private LocalDate birthDate;

    @Embedded
    private PhoneNumber phoneNumber;

    @Embedded
    private Address address;

    private Boolean isSocialLogin;

    @Builder
    public User(UserId userId, String password, String name) {
        this.userId = userId;
        this.password = password;
        this.role = Role.ROLE_USER;
        this.name = name;
    }
}
