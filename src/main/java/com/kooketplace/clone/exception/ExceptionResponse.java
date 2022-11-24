package com.kooketplace.clone.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * PackageName : com.kooketplace.clone.exception
 * FileName : ExceptionResponse
 * Author : Koorung
 * Date : 2022년 11월 24일
 * Description : 예외 응답을 정의한 클래스
 */
@Getter
@RequiredArgsConstructor
public class ExceptionResponse {
    private final List<ExceptionInfo> exceptionInfoList = new ArrayList<>();

    // 예외정보를 추가하는 메소드
    public void addExceptionInfo(ExceptionInfo exceptionInfo) {
        exceptionInfoList.add(exceptionInfo);
    }
}
