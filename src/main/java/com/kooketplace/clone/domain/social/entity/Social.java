package com.kooketplace.clone.domain.social.entity;

import com.kooketplace.clone.domain.user.entity.User;
import lombok.Getter;

import javax.persistence.*;

/**
 * PackageName : com.kooketplace.clone.domain.social.entity
 * FileName : Social
 * Author : Koorung
 * Date : 2022년 11월 22일
 * Description : 소셜로그인 엔티티 클래스
 */
@Entity
@Getter
public class Social {

    @Id
    @GeneratedValue
    @Column(name = "social_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
