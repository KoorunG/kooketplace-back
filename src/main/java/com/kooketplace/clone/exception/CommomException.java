package com.kooketplace.clone.exception;

/**
 * PackageName : com.kooketplace.clone.exception
 * FileName : CommomException
 * Author : Koorung
 * Date : 2022년 11월 24일
 * Description : 공통 예외를 처리하는 추상클래스, 비즈니스 예외는 이 클래스를 상속받아야한다.
 */
public abstract class CommomException extends RuntimeException {

    public CommomException(String message) {
        super(message);
    }

    public CommomException(String message, Throwable cause) {
        super(message, cause);
    }

    // 여기서 에러코드는 발생한 에러종류를 의미한다. ex) Length, Email, NotNull etc...
    public abstract String getErrorCode();
}
