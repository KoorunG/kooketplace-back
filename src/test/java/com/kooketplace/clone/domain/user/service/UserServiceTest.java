package com.kooketplace.clone.domain.user.service;

import com.kooketplace.clone.domain.embedded.Address;
import com.kooketplace.clone.domain.embedded.PhoneNumber;
import com.kooketplace.clone.domain.user.entity.User;
import com.kooketplace.clone.domain.user.entity.UserId;
import com.kooketplace.clone.domain.user.repository.UserRepository;
import com.kooketplace.clone.domain.user.request.UserCreateRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * PackageName : com.kooketplace.clone.domain.user.service
 * FileName : UserServiceTest
 * Author : Koorung
 * Date : 2022년 11월 23일
 * Description : UserService 테스트
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
    @Test
    @DisplayName("첫 회원가입 시 포인트 3000 지급")
    void test4() {
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
        User joined = userRepository.findByUserId(userId).orElseThrow();

        //then
        assertThat(joined).extracting("point").extracting("point").isEqualTo(3000);
    }

    @Test
    @DisplayName("포인트 적립")
    void test5() {
        //given
        User user = User.builder()
                .userId(new UserId("koorung"))
                .name("쿠렁")
                .password("test")
                .address(Address.builder()
                        .sido("경기도")
                        .signgu("남양주시")
                        .dong("도농동").build())
                .birthDate(LocalDate.now())
                .phoneNumber(new PhoneNumber("010-1234-1234"))
                .build();
        //when
        userService.savePoint(user, 2000);        // 포인트를 2천만큼 적립하는 상황
        assertThat(user).extracting("point").extracting("point").isEqualTo(5000);
    }

    @Test
    @DisplayName("보유 포인트보다 많이 차감하면 오류 발생")
    void test6() {
        //given
        User user = User.builder()
                .userId(new UserId("koorung"))
                .name("쿠렁")
                .password("test")
                .address(Address.builder()
                        .sido("경기도")
                        .signgu("남양주시")
                        .dong("도농동").build())
                .birthDate(LocalDate.now())
                .phoneNumber(new PhoneNumber("010-1234-1234"))
                .build();

        //when
        assertThrows(IllegalArgumentException.class, () -> {
            userService.usePoint(user, 4000);
        });
    }
}