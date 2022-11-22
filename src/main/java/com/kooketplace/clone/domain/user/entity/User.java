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
    private UserId userId;      // 로그인ID (PK)
    private String password;    // 패스워드
    @Enumerated(EnumType.STRING)
    private Role role;          // 권한 (ROLE_USER, ROLE_ADMIN)
    private String name;        // 유저이름

    private LocalDate birthDate; // 생년월일
    @Embedded
    private PhoneNumber phoneNumber; // 전화번호

    @Embedded
    private Address address;        // 주소

    @Builder
    public User(UserId userId, String password, String name, PhoneNumber phoneNumber, LocalDate birthDate) {
        this.userId = userId;
        this.password = password;
        this.role = Role.ROLE_USER;     // 초기가입 시 USER 권한으로 설정
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }
}
