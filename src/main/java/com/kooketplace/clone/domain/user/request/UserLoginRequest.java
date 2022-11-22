package com.kooketplace.clone.domain.user.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * PackageName : com.kooketplace.clone.domain.user.request
 * FileName : UserLoginRequest
 * Author : Koorung
 * Date : 2022년 11월 22일
 * Description :
 */
@Getter
@NoArgsConstructor
public class UserLoginRequest {

    private String userId;
    private String password;

    public UserLoginRequest(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
