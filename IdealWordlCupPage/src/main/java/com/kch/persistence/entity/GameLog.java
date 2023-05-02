package com.kch.persistence.entity;

import com.kch.persistence.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name="TBL_GAME_LOGS")
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GameLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="game_log_id")
    private Long gameLogId;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name="game_id")
    private Game gameId;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name="user_id")
    private User userId;

    @Column(name="game_log")
    private String gameLog;

    @CreatedDate
    @Column(name="reg_dt")
    private LocalDateTime regDt;

    @Builder
    private GameLog(Long gameLogId, Game gameId, User userId, String gameLog) {
        this.gameLogId = gameLogId;
        this.gameId = gameId;
        this.userId = userId;
        this.gameLog = gameLog;
    }
}
