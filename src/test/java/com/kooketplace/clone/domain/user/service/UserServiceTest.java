package com.kooketplace.clone.domain.user.service;

import com.kooketplace.clone.domain.user.entity.UserId;
import com.kooketplace.clone.domain.user.repository.UserRepository;
import com.kooketplace.clone.domain.user.request.UserCreateRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * PackageName : com.kooketplace.clone.domain.user.service
 * FileName : UserServiceTest
 * Author : Koorung
 * Date : 2022년 11월 23일
 * Description : UserService의 기능을 테스트
 */
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    @DisplayName("아이디를 입력하지 않을 경우 회원가입 실패")
    void test1() {
        //given
        UserCreateRequest createRequest = UserCreateRequest.builder()
                .password("test")
                .name("쿠렁")
                .phoneNumber("010-1234-1234")
                .birthDate("1992-12-01")
                .build();
        //when
        assertThrows(DataIntegrityViolationException.class, () -> {
            userService.join(createRequest);
        });
    }

    @Test
    @DisplayName("비밀번호를 입력하지 않을 경우 회원가입 실패")
    void test3() {
        //given
        UserCreateRequest createRequest = UserCreateRequest.builder()
                .userId("koorung")
                .name("쿠렁")
                .phoneNumber("010-1234-1234")
                .birthDate("1992-12-01")
                .build();
        //when
        assertThrows(IllegalArgumentException.class, () -> {
            userService.join(createRequest);
        });
    }

    @Test
    @DisplayName("회원가입 성공")
    void test2() {
        //given
        UserCreateRequest createRequest = UserCreateRequest.builder()
                .userId("koorung")
                .password("test")
                .name("쿠렁")
                .phoneNumber("010-1234-1234")
                .birthDate("1992-12-01")
                .build();
        //when
        UserId userId = userService.join(createRequest);
        assertThat(userId.toString()).isEqualTo("koorung");
    }
}