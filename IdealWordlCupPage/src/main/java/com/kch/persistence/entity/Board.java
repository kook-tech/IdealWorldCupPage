package com.kch.persistence.entity;

import com.kch.persistence.BaseEntity;
import com.kch.service.model.dtos.request.BoardReqDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="TBL_BOARDS")
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(
        name="id",
        column = @Column(name="board_id")
)
public class Board extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    @Column(name="board_title",length = 30)
    private String boardTitle;

    @Column(name="board_cotent")
    private String boardContent;

    @Column(name="view_cnt")
    private int view_cnt;

    @Column(name="like_cnt")
    private int like_cnt;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    private List<Reply> replyList;


    @Builder
    private Board(User user, Category category, String boardTitle, String boardContent) {
        this.user = user;
        this.category = category;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
    }

    public void updateBoard(BoardReqDTO.UPDATE update){
        this.boardTitle = update.getBoardTitle();
        this.boardContent = update.getBoardContent();
    }
}
