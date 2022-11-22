package com.kooketplace.clone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * PackageName : com.kooketplace.clone.config
 * FileName : CorsConfig
 * Author : Koorung
 * Date : 2022년 11월 22일
 * Description : Cors 관련 설정 클래스
 */
@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);   // 서버가 응답할 때 json을 자바스크립트에서 처리할 수 있게 할지 여부 설정
        config.addAllowedOriginPattern("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);    // 모든 요청에 대해 적용
        return new CorsFilter(source);
    }
}
