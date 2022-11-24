package com.kooketplace.clone.exception.customvalidator;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * PackageName : com.kooketplace.clone.exception.customvalidator
 * FileName : SpecialValidator
 * Author : Koorung
 * Date : 2022년 11월 24일
 * Description :
 */
public class SpecialValidator implements ConstraintValidator<Special, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(!StringUtils.hasText(value)) return true;
        return value.matches("^(?=.*[\\{\\}\\[\\]\\/?.,;:|\\)*~`!^\\-_+<>@\\#$%&\\\\\\=\\(\\'\\\"]).*$");
    }
}
