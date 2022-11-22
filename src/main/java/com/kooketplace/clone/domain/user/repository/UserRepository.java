package com.kooketplace.clone.domain.user.repository;

import com.kooketplace.clone.domain.user.entity.User;
import com.kooketplace.clone.domain.user.entity.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * PackageName : com.kooketplace.clone.domain.user.repository
 * FileName : UserRepository
 * Author : Koorung
 * Date : 2022년 11월 22일
 * Description : 유저 도메인의 레포지토리
 */
public interface UserRepository extends JpaRepository<User, UserId> {
    Optional<User> findByUserId(UserId userId);
}
