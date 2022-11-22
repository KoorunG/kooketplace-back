package com.kooketplace.clone.domain.user.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * PackageName : com.kooketplace.clone.domain.user.entity
 * FileName : PhoneNumber
 * Author : Koorung
 * Date : 2022년 11월 22일
 * Description :
 */
@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
public class PhoneNumber {

    private Integer areaNumber;
    private Integer middleNumber;
    private Integer endNumber;

    /**
     * 전체 전화번호를 반환받는 메소드
     * @return
     */
    public String changeFullNumber() {
        return this.areaNumber + "-" + this.middleNumber + "-" + this.endNumber;
    }
}
