package com.kooketplace.clone.exception.customvalidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * PackageName : com.kooketplace.clone.exception
 * FileName : AlphaAndNumeric
 * Author : Koorung
 * Date : 2022년 11월 24일
 * Description : 알파벳과 숫자를 가지고 있는지 여부를 체크하는 커스텀 @Valid 애노테이션
 */
@Constraint(validatedBy = AlphaAndNumericValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AlphaAndNumeric {
    String message() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
