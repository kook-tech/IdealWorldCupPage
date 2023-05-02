package com.kch.persistence.entity;

import com.kch.persistence.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="TBL_REPLIES")
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(
        name="id",
        column = @Column(name="reply_id")
)
public class Reply extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name="user_id", nullable = false)
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name="board_id", nullable = true)
    private Board boardId;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name="game_id", nullable = true)
    private Game gameId;

    @Column(name="content", nullable = false, length = 100)
    private String content;

    @Builder
    private Reply(User userId, Board boardId, Game gameId, String content) {
        this.userId = userId;
        this.boardId = boardId;
        this.gameId = gameId;
        this.content = content;
    }
}
