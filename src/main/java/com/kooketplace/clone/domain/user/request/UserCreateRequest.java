package com.kooketplace.clone.domain.user.request;

import com.kooketplace.clone.domain.user.entity.PhoneNumber;
import com.kooketplace.clone.domain.user.entity.User;
import com.kooketplace.clone.domain.user.entity.UserId;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * PackageName : com.kooketplace.clone.domain.user.request
 * FileName : UserCreateRequest
 * Author : Koorung
 * Date : 2022년 11월 22일
 * Description :
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserCreateRequest {
    @NotEmpty(message = "아이디는 반드시 입력해야합니다.")
    private UserId userId;
    @NotEmpty(message = "비밀번호는 반드시 입력해야합니다.")
    private String password;
    @NotEmpty(message = "이름은 반드시 입력해야합니다.")
    private String name;
    private PhoneNumber phoneNumber;
    private LocalDate birthDate;

    @Builder
    public UserCreateRequest(String userId, String password, String name, String phoneNumber, String birthDate) {
        this.userId = new UserId(userId);
        this.password = password;
        this.name = name;
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public User toEntity() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return User.builder()
                .userId(userId)
                .password(encoder.encode(password))
                .name(name)
                .phoneNumber(phoneNumber)
                .birthDate(birthDate)
                .build();
    }
}
