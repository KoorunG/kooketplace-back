package com.kooketplace.clone.config.auth;

import java.util.Date;

/**
 * PackageName : com.kooketplace.clone.config.auth
 * FileName : JwtConstants
 * Author : Koorung
 * Date : 2022년 11월 22일
 * Description : JWT 관련 상수를 관리하는 클래스
 */
public class JwtConstants {
    public static final String JWT_SECRET = "koorung";
    public static final String JWT_SUBJECT = "JWT Token";
    public static final Date JWT_EXPIRES_AT = new Date(System.currentTimeMillis() + 60000 * 30);
}
