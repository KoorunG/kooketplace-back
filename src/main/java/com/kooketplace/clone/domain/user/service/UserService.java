package com.kooketplace.clone.domain.user.service;

import com.kooketplace.clone.domain.user.entity.User;
import com.kooketplace.clone.domain.user.entity.UserId;
import com.kooketplace.clone.domain.user.repository.UserRepository;
import com.kooketplace.clone.domain.user.request.UserCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PackageName : com.kooketplace.clone.domain.user.service
 * FileName : UserService
 * Author : Koorung
 * Date : 2022년 11월 22일
 * Description : 유저 도메인의 서비스
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Transactional
    public UserId join(UserCreateRequest request) {
        // 요청을 엔티티로 변환
        User user = request.toEntity();
        // 패스워드 인코딩
        user.encodePassword(passwordEncoder);
        // DB에 엔티티 저장
        userRepository.save(user);
        // 식별자 리턴
        return user.getUserId();
    }

    public void savePoint(User user, int point) {
        user.getPoint().plusPoint(point);
    }

    public void usePoint(User user, int point) {
        user.getPoint().minusPoint(point);
    }
}
