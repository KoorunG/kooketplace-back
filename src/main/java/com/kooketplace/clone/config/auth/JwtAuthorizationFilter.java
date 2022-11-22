package com.kooketplace.clone.config.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.kooketplace.clone.domain.user.entity.User;
import com.kooketplace.clone.domain.user.entity.UserId;
import com.kooketplace.clone.domain.user.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * PackageName : com.kooketplace.clone.config.auth
 * FileName : JwtAuthorizationFilter
 * Author : Koorung
 * Date : 2022년 11월 22일
 * Description :
 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    private final UserRepository userRepository;
    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UserRepository userRepository) {
        super(authenticationManager);
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String authorization = request.getHeader("Authorization");

        // JWT 토큰을 가지고 있는지 검사 - 가지고 있지 않다면 다음 필터로 넘어가고 return 처리
        if(!StringUtils.hasText(authorization) || !StringUtils.startsWithIgnoreCase(authorization, "Bearer ")) {
            chain.doFilter(request, response);
            return;
        }

        String token = StringUtils.replace(authorization, "Bearer ", "");
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512(JwtConstants.JWT_SECRET)).build().verify(token);
        String userId = decodedJWT.getClaim("id").asString();

        if(StringUtils.hasText(userId)) {
            User user = userRepository.findByUserId(new UserId(userId)).orElseThrow();
            PrincipalDetails principalDetails = new PrincipalDetails(user);
            Authentication authentication = new UsernamePasswordAuthenticationToken(principalDetails, null, principalDetails.getAuthorities());
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(authentication);

            chain.doFilter(request, response);
        }
    }
}
