package com.kch.persistence.entity;

import com.kch.persistence.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name="TBL_GAME_LOGS")
@ToString
@Getter
@Builder
@NoArgsConstructor
public class GameLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="game_log_id")
    private Long gameLogId;

    @ManyToOne
    @Column(name="game_id")
    private Game gameId;

    @ManyToOne
    @Column(name="user_id")
    private User userId;

    @Column(name="game_log")
    private String gameLog;

    @CreatedDate
    private LocalDateTime regDt;

    @Builder
    public GameLog(Long gameLogId, Game gameId, User userId, String gameLog, LocalDateTime regDt) {
        this.gameLogId = gameLogId;
        this.gameId = gameId;
        this.userId = userId;
        this.gameLog = gameLog;
        this.regDt = regDt;
    }
}
