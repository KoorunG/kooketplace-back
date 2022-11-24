package com.kooketplace.clone.domain.user;

import com.kooketplace.clone.domain.user.entity.UserId;
import com.kooketplace.clone.domain.user.request.UserCreateRequest;
import com.kooketplace.clone.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * PackageName : com.kooketplace.clone.domain.user
 * FileName : UserController
 * Author : Koorung
 * Date : 2022년 11월 22일
 * Description : 유저 도메인의 컨트롤러
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 회원가입을 처리하고 식별자를 String으로 리턴하는 메소드
     * @param request 요청
     * @return 유저 식별자
     */
    @PostMapping("/join")
    public String join(@RequestBody @Valid UserCreateRequest request) {
        UserId saved = userService.join(request);
        return saved.toString();
    }

    @GetMapping("/user/test")
    public String test() {
        return "테스트 호출 성공!";
    }
}
