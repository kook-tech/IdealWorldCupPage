package com.kch.persistence.entity;

import com.kch.persistence.BaseEntity;
import com.kch.service.model.dtos.request.GameElementReqDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TBL_GAME_ELEMENTS")
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(
        name="id",
        column = @Column(name="element_id")
)
public class GameElement extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", referencedColumnName = "game_id")
    private Game game;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id", referencedColumnName = "file_id")
    private File file;

    @Column(name = "element_title", nullable = false, length = 20)
    private String elementTitle;

    @Column(name = "element_select_cnt", nullable = false)
    private int elementSelectCnt;

    @Column(name = "element_win_cnt", nullable = false)
    private int elementWinCnt;

    @Builder
    private GameElement(Game game, File file, String elementTitle, int elementSelectCnt, int elementWinCnt) {
        this.game = game;
        this.file = file;
        this.elementTitle = elementTitle;
        this.elementSelectCnt = elementSelectCnt;
        this.elementWinCnt = elementWinCnt;
    }

    public void updateGameElement(GameElementReqDTO.UPDATE update){
        this.file = update.getFileId();
        this.elementTitle = update.getElementTitle();
    }
}