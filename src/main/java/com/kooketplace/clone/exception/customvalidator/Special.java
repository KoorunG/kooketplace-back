package com.kooketplace.clone.exception.customvalidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * PackageName : com.kooketplace.clone.exception.customvalidator
 * FileName : Special
 * Author : Koorung
 * Date : 2022년 11월 24일
 * Description :
 */
@Constraint(validatedBy = SpecialValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Special {
    String message() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
