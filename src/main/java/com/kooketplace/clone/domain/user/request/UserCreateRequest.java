package com.kooketplace.clone.domain.user.request;

import lombok.Builder;
import lombok.Getter;

/**
 * PackageName : com.kooketplace.clone.domain.user.request
 * FileName : UserCreateRequest
 * Author : Koorung
 * Date : 2022년 11월 22일
 * Description :
 */
@Getter
public class UserCreateRequest {
    private final String userId;
    private final String password;
    private final String name;

    @Builder
    public UserCreateRequest(String userId, String password, String name) {
        this.userId = userId;
        this.password = password;
        this.name = name;
    }
}
