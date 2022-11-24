package com.kooketplace.clone.exception.customvalidator;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * PackageName : com.kooketplace.clone.exception.customvalidator
 * FileName : PhoneNumberValidator
 * Author : Koorung
 * Date : 2022년 11월 24일
 * Description :
 */
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(!StringUtils.hasText(value)) return true;
        return value.matches("^\\d{3}-\\d{3,4}-\\d{4}$");
    }
}
