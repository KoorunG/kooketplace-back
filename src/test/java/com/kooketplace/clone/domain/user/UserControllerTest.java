package com.kooketplace.clone.domain.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kooketplace.clone.domain.user.request.UserCreateRequest;
import com.kooketplace.clone.domain.user.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * PackageName : com.kooketplace.clone.domain.user
 * FileName : UserControllerTest
 * Author : Koorung
 * Date : 2022년 11월 24일
 * Description : UserController 테스트
 */
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    @DisplayName("이메일을 입력하지 않으면 에러 발생")
    void test1() throws Exception {
        //given
        mockMvc.perform(post("/join")
                .contentType(APPLICATION_JSON)
                .characterEncoding(UTF_8)
                .content(createUserCreateRequest("test1234", "test", null)))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    @DisplayName("비밀번호를 입력하지 않으면 에러 발생")
    void test2() throws Exception {
        //given
        mockMvc.perform(post("/join")
                        .contentType(APPLICATION_JSON)
                        .characterEncoding(UTF_8)
                        .content(createUserCreateRequest("test1234", null, "test@naver.com")))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    @DisplayName("정상 회원가입")
    void test3() throws Exception {
        //given
        mockMvc.perform(post("/join")
                        .contentType(APPLICATION_JSON)
                        .characterEncoding(UTF_8)
                        .content(createUserCreateRequest("test1234", "test1234", "test@naver.com")))
                .andExpect(status().isOk())
                .andDo(print());
    }



    private String createUserCreateRequest(String userId, String password, String email) throws JsonProcessingException {
        UserCreateRequest createRequest = UserCreateRequest
                .builder()
                .userId(userId)
                .password(password)
                .name("테스트")
                .phoneNumber("010-1234-1234")
                .birthDate("1992-12-01")
                .email(email)
                .build();

        return mapper.writeValueAsString(createRequest);
    }
}