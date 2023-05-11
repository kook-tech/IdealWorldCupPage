package com.kch.persistence.entity;

import com.kch.persistence.BaseEntity;
import com.kch.service.model.dtos.request.ReplyReqDTO;
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
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", referencedColumnName = "board_id", nullable = true)
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", referencedColumnName = "game_id", nullable = true)
    private Game game;

    @Column(name="content", nullable = false, length = 100)
    private String content;

    @Builder //게시판에 대한 댓글
    private Reply(User user, Board board, String content) {
        this.user = user;
        this.board = board;
        this.content = content;
    }
    @Builder //게임에 대한 댓글
    private Reply(User user, Game game, String content) {
        this.user = user;
        this.game = game;
        this.content = content;
    }

    public void updateReply(ReplyReqDTO.UPDATE update){
        this.content = update.getContent();
    }
}
