package com.kooketplace.clone.domain.user.entity;

import com.kooketplace.clone.domain.embedded.Address;
import com.kooketplace.clone.domain.embedded.PhoneNumber;
import com.kooketplace.clone.domain.embedded.Point;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

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

    private String email;       // 이메일
    private LocalDate birthDate; // 생년월일
    @Embedded
    private PhoneNumber phoneNumber; // 전화번호

    @Embedded
    private Address address;        // 주거래지역 (aa도 bb시 cc동)

    @Embedded
    private Point point;            // 보유포인트

    @Builder
    public User(UserId userId, String password, String name, String email, PhoneNumber phoneNumber, LocalDate birthDate, Address address) {
        this.userId = userId;
        this.password = password;
        this.role = Role.ROLE_USER;     // 초기가입 시 USER 권한으로 설정
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.address = address;
        this.point = new Point(3000);   // 가입시 기본 포인트 3000p 지급
    }

    // 패스워드를 인코딩하는 함수
    public void encodePassword(PasswordEncoder encoder) {
        this.password = encoder.encode(password);
    }
}
