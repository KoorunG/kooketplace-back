package com.kooketplace.clone.domain.user.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * PackageName : com.kooketplace.clone.domain.user.entity
 * FileName : Address
 * Author : Koorung
 * Date : 2022년 11월 22일
 * Description :
 */
@Getter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
public class Address {

    private String city;
    private String street;
    private String zipCode;
}