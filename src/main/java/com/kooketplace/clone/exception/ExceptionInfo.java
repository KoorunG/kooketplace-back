package com.kooketplace.clone.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * PackageName : com.kooketplace.clone.exception
 * FileName : ExceptionInfo
 * Author : Koorung
 * Date : 2022년 11월 24일
 * Description : 에러정보를 정의한 클래스
 */
@Getter
@RequiredArgsConstructor
public class ExceptionInfo {
    private String errorCode;
    private String fieldName;
    private String message;

    @Builder
    public ExceptionInfo(String errorCode, String fieldName, String message) {
        this.errorCode = errorCode;
        this.fieldName = fieldName;
        this.message = message;
    }
}
