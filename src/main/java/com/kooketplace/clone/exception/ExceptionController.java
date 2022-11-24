package com.kooketplace.clone.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * PackageName : com.kooketplace.clone.exception
 * FileName : ExceptionController
 * Author : Koorung
 * Date : 2022년 11월 24일
 * Description : 예외처리를 담당하는 컨트롤러
 */
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionController {

    // 커스텀 에러를 처리하는 메소드
    @ExceptionHandler
    public ExceptionResponse handleCustomException(CommomException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.addExceptionInfo(
                ExceptionInfo.builder()
                        .errorCode(e.getErrorCode())
                        .message(e.getMessage())
                        .build());
        return exceptionResponse;
    }

    // 필드에러를 처리하는 메소드
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleFieldException(MethodArgumentNotValidException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        if (e.hasFieldErrors()) {
            e.getFieldErrors().forEach(fieldError -> {
                exceptionResponse.addExceptionInfo(ExceptionInfo.builder()
                        .fieldName(fieldError.getField())
                        .errorCode(fieldError.getCode())
                        .message(fieldError.getDefaultMessage())
                        .build());
            });
        }
        return exceptionResponse;
    }
}
