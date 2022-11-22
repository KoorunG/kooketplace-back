package com.kooketplace.clone.domain.Item.entity;

import com.kooketplace.clone.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * PackageName : com.kooketplace.clone.domain.Item.entity
 * FileName : Item
 * Author : Koorung
 * Date : 2022년 11월 22일
 * Description : 아이템 엔티티 클래스
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Lob
    private String description;

    private Integer price;

    private String itemStatus;

    private String location;

    private Integer viewCount;

    private Integer wishCount;

    private LocalDate registerDate;

    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
