package com.kooketplace.clone.config.auth;

import com.kooketplace.clone.domain.user.entity.User;
import com.kooketplace.clone.domain.user.entity.UserId;
import com.kooketplace.clone.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * PackageName : com.kooketplace.clone.config.auth
 * FileName : PrincipalDetailsService
 * Author : Koorung
 * Date : 2022년 11월 22일
 * Description : UserDetails를 리턴하는 loadUserByUsername을 구현하기 위한 서비스 클래스
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername 실행됨 :::: {}", username);
        User user = userRepository.findByUserId(new UserId(username)).orElseThrow();
        return new PrincipalDetails(user);
    }
}
