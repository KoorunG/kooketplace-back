package com.kooketplace.clone.config.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kooketplace.clone.domain.user.request.UserLoginRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.kooketplace.clone.config.auth.JwtConstants.*;

/**
 * PackageName : com.kooketplace.clone.config.auth
 * FileName : JwtAuthenticationFilter
 * Author : Koorung
 * Date : 2022년 11월 22일
 * Description :
 */
@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            UserLoginRequest loginRequest = objectMapper.readValue(request.getInputStream(), UserLoginRequest.class);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getUserId(), loginRequest.getPassword());

            return authenticationManager.authenticate(authenticationToken);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException authenticationException) {
        log.error("인증되지 않은 사용자 ::: ", authenticationException);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authencation) {
        PrincipalDetails principalDetails = (PrincipalDetails) authencation.getPrincipal();
        log.info("인증된 사용자 ::: [{}][{}]", principalDetails.getRole(), principalDetails.getUsername());

        String token = JWT.create()
                .withSubject(JWT_SUBJECT)
                .withExpiresAt(JWT_EXPIRES_AT) // 토큰 만료시간 -> Date 타입으로 받아야 함 (30분)
                .withClaim("id", principalDetails.getUsername())
                .sign(Algorithm.HMAC512(JWT_SECRET));

        response.addHeader("Authorization", "Bearer " + token);
    }
}
