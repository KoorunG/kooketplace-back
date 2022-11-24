package com.kooketplace.clone.exception.customvalidator;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * PackageName : com.kooketplace.clone.exception
 * FileName : AlphaAndNumericValidator
 * Author : Koorung
 * Date : 2022년 11월 24일
 * Description : 영문자 및 숫자 포함여부 검사기
 */
public class AlphaAndNumericValidator implements ConstraintValidator<AlphaAndNumeric, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(!StringUtils.hasText(value)) return true;
        return value.matches("^(?=.*[a-zA-Z])(?=.*[0-9]).*$");
    }
}
