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

//        UserId userId = request.getUserId();
//        String rawPassword = request.getPassword();
//        String encPassword = passwordEncoder.encode(rawPassword);
//        String name = request.getName();
//
//        User user = User.builder()
//                .userId(userId)
//                .password(encPassword)
//                .name(name)
//                .build();

        User user = request.toEntity();
        UserId userId = user.getUserId();

        userRepository.save(user);

        return userId;
    }
}
