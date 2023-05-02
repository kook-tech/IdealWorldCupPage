package com.kch.persistence.entity;

import com.kch.persistence.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

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
    @Column(name="user_id")
    private User userId;

    @OneToOne(fetch = FetchType.LAZY)
    @Column(name="category_id")
    private Category categoryId;

    @Column(name="board_title",length = 30)
    private String boardTitle;

    @Column(name="view_cnt")
    private int view_cnt;

    @Column(name="like_cnt")
    private int like_cnt;

    @Builder
    private Board(User userId, Category categoryId, String boardTitle) {
        this.userId = userId;
        this.categoryId = categoryId;
        this.boardTitle = boardTitle;
        this.view_cnt = 0;
        this.like_cnt = 0;
    }
}
