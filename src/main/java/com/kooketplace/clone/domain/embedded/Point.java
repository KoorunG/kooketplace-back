package com.kooketplace.clone.domain.embedded;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * PackageName : com.kooketplace.clone.domain.embedded
 * FileName : Point
 * Author : Koorung
 * Date : 2022년 11월 24일
 * Description : 포인트에 관한 임베디드 클래스
 */
@Getter
@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
public class Point {
    private int point;
    public Point(int point) {
        this.point = point;
    }

    // 포인트 차감
    public void minusPoint(int used) {
        if(this.point < used) {
            throw new IllegalArgumentException("현재 보유한 포인트보다 많습니다.");
        }
        this.point -= used;
    }

    // 포인트 적립
    public void plusPoint(int saved) {
        this.point += saved;
    }
}
