package com.kch.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name="TBL_GAME_LOGS")
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class) //baseentity 상속 안해서 생성일자 auditing하게 따로 등록
public class GameLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="game_log_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", referencedColumnName = "game_id")
    private Game game;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @Column(name="game_log")
    private String gameLog;

    @CreatedDate
    @Column(name="reg_dt")
    private LocalDateTime regDt;

    @Builder
    private GameLog( Game game, User user, String gameLog) {
        this.game = game;
        this.user = user;
        this.gameLog = gameLog;
    }

    //수정 메서드 필요없음.

}
