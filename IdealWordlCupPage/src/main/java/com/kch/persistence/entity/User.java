package com.kch.persistence.entity;

import com.kch.persistence.BaseEntity;
import com.kch.service.model.dtos.request.UserReqDTO;
import com.kch.service.model.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TBL_USERS")
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(
        name = "id",
        column = @Column(name = "user_id")
)
public class User extends BaseEntity {
    @Column(name = "login_id", nullable = false, unique = true, length = 10, updatable = false)
    private String loginId;

    @Column(name = "password", nullable = false, length = 16)
    private String password;

    @Column(name = "name", nullable = false, length = 8)
    private String name;

    @Column(name="birth", updatable = false)
    private LocalDateTime birth;

    @Column(name="email", nullable = false, length = 30)
    private String email;

    @Column(name="role", nullable = false, length = 20)
    private UserRole role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Board> boardList;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Reply> replyList;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<GameLog> gameLogList;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Game> gameList;



    @Builder
    private User(String loginId, String password, String name, LocalDateTime birth, String email, UserRole role) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.email = email;
        this.role = role;
    }

    public void updateUser(UserReqDTO.UPDATE update){
        this.password = update.getPassword();
        this.name = update.getName();
        this.email = update.getEmail();
    }
}
