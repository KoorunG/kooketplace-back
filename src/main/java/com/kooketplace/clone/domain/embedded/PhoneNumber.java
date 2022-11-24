package com.kooketplace.clone.domain.embedded;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PackageName : com.kooketplace.clone.domain.user.entity
 * FileName : PhoneNumber
 * Author : Koorung
 * Date : 2022년 11월 22일
 * Description : 휴대전화번호에 대한 임베디드 클래스
 */
@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
public class PhoneNumber {

    @Column(name = "phone_number")
    private String storedNumber;

    public PhoneNumber(String storedNumber) {

        // null값이면 객체생성 X
        if(!StringUtils.hasText(storedNumber)){
            return;
        }

        // 하이푼이 포함되어있다면 제거
        if (storedNumber.contains("-")) {
            this.storedNumber = StringUtils.replace(storedNumber, "-", "");
            return;
        }

        // 공백이 포함되어있다면 제거
        if (StringUtils.containsWhitespace(storedNumber)) {
            this.storedNumber = StringUtils.trimAllWhitespace(storedNumber);
            return;
        }

        // 이외엔 그대로 출력
        this.storedNumber = storedNumber;
    }
}
