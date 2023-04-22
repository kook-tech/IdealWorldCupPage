package com.kch.persistence.entity;

import com.kch.persistence.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "TBL_GAME_ELEMENTS")
@ToString
@Getter
@Builder
@NoArgsConstructor
@AttributeOverride(
        name="id",
        column = @Column(name="element_id")
)
public class GameElement extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("gameId")
    private Game gameId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id", referencedColumnName = "id")
    private File fileId;

    @Column(name = "element_title", nullable = false, length = 20)
    private String elementTitle;

    @Column(name = "element_select_cnt", nullable = false)
    private int elementSelectCnt;

    @Column(name = "element_win_cnt", nullable = false)
    private int elementWinCnt;

    @Builder
    public GameElement(Game gameId, File fileId, String elementTitle, int elementSelectCnt, int elementWinCnt) {
        this.gameId = gameId;
        this.fileId = fileId;
        this.elementTitle = elementTitle;
        this.elementSelectCnt = elementSelectCnt;
        this.elementWinCnt = elementWinCnt;
    }
}