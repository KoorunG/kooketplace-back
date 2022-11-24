package com.kooketplace.clone.domain.embedded;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * PackageName : com.kooketplace.clone.domain.user.entity
 * FileName : Address
 * Author : Koorung
 * Date : 2022년 11월 22일
 * Description : 주소에 관련된 임베디드 클래스, 시도 - 시군구 - 동 구조로 이루어짐
 */
@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
public class Address {

    private String sido;
    private String signgu;
    private String dong;

    @Builder
    public Address(String sido, String signgu, String dong) {
        this.sido = sido;
        this.signgu = signgu;
        this.dong = dong;
    }
}