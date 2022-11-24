package com.kooketplace.clone.domain.user.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.IdClass;
import java.io.Serializable;

/**
 * PackageName : com.kooketplace.clone.domain.user.entity
 * FileName : UserId
 * Author : Koorung
 * Date : 2022년 11월 22일
 * Description :
 */
@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
public class UserId implements Serializable {
    @Column(name = "user_id")
    private String id;
    public UserId(String id) {
        this.id = id;
    }

    public String toString(){
        return id;
    }
}
