package com.kooketplace.clone.domain.user.request;

import com.kooketplace.clone.domain.embedded.Address;
import com.kooketplace.clone.domain.embedded.PhoneNumber;
import com.kooketplace.clone.domain.user.entity.User;
import com.kooketplace.clone.domain.user.entity.UserId;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorManagerImpl;
import org.springframework.util.StringUtils;

import javax.validation.Constraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "아이디는 반드시 입력해야합니다.")
    @Length(min = 5, max = 11, message = "아이디는 5자이상, 11자이하여야 합니다.")
    private String userId;
    @NotEmpty(message = "비밀번호는 반드시 입력해야합니다.")
    @Length(min = 8, message = "비밀번호는 최소 8자 이상이어야 합니다.")
    private String password;
    @NotEmpty(message = "이름은 반드시 입력해야합니다.")
    private String name;

    @NotEmpty(message = "이메일은 반드시 입력해야합니다.")
    @Email(message = "올바른 형식의 이메일을 입력해야합니다.", regexp = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$")
    private String email;
    private String phoneNumber;
    private LocalDate birthDate;
    private Address address;

    @Builder
    public UserCreateRequest(String userId, String password, String name, String email, String phoneNumber, String birthDate, Address address) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.address = address;
    }

    public User toEntity() {
        return User.builder()
                .userId(new UserId(userId))
                .password(password)
                .name(name)
                .email(email)
                .phoneNumber(new PhoneNumber(phoneNumber))
                .birthDate(birthDate)
                .address(address)
                .build();
    }
}
