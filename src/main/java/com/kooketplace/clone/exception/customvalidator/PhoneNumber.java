package com.kooketplace.clone.exception.customvalidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * PackageName : com.kooketplace.clone.exception.customvalidator
 * FileName : PhoneNumber
 * Author : Koorung
 * Date : 2022년 11월 24일
 * Description :
 */

@Constraint(validatedBy = PhoneNumberValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumber {
    String message() default "올바른 전화번호 형식을 입력해야합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
