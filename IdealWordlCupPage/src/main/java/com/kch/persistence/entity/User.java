package com.kch.persistence.entity;

import com.kch.persistence.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_USERS")
@ToString
@Getter
@Builder
@NoArgsConstructor
@AttributeOverride(
        name = "id",
        column = @Column(name = "user_id")
)
public class User extends BaseEntity {
    @Column(name = "login_id", nullable = false, unique = true, length = 10)
    private String loginId;

    @Column(name = "password", nullable = false, length = 16)
    private String password;

    @Column(name = "name", nullable = false, length = 8)
    private String name;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "addr", nullable = false, length = 40)
    private String addr;

    @Builder
    public User(String loginId, String password, String name, int age, String addr) {
        super();
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.age = age;
        this.addr = addr;
    }
}
