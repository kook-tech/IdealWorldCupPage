package com.kch.persistence.entity;

import com.kch.persistence.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="TBL_REPLIES")
@ToString
@Getter
@Builder
@NoArgsConstructor
@AttributeOverride(
        name="id",
        column = @Column(name="reply_id")
)
public class Reply extends BaseEntity {
    @ManyToOne
    @Column(name="user_id")
    private User userId;

    @ManyToOne
    @Column(name="board_id")
    private Board boardId;

    @ManyToOne
    @Column(name="game_id")
    private Game gameId;

    @Column(name="content", length = 100)
    private String content;

    @Builder
    public Reply(User userId, Board boardId, Game gameId, String content) {
        this.userId = userId;
        this.boardId = boardId;
        this.gameId = gameId;
        this.content = content;
    }
}
