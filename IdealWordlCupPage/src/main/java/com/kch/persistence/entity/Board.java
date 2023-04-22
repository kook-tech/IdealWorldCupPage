package com.kch.persistence.entity;

import com.kch.persistence.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="TBL_BOARDS")
@ToString
@Getter
@Builder
@NoArgsConstructor
@AttributeOverride(
        name="id",
        column = @Column(name="board_id")
)
public class Board extends BaseEntity {
    @ManyToOne
    @Column(name="user_id")
    private User userId;

    @OneToOne
    @Column(name="category_id")
    private Category categoryId;

    @Column(name="board_title",length = 30)
    private String boardTitle;

    @Column(name="view_cnt")
    private int view_cnt;

    @Column(name="like_cnt")
    private int like_cnt;

}
