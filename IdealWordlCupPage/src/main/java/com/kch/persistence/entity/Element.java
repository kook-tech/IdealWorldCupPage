package com.kch.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TBL_ELEMENTS")
public class Element {
    @EmbeddedId
    private ElementId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("gameId")
    private Game game;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id", referencedColumnName = "id")
    private File file;

    @Column(name = "element_title", nullable = false, length = 20)
    private String elementTitle;

    @Column(name = "element_select_cnt", nullable = false)
    private int elementSelectCnt = 0;

    @Column(name = "element_win_cnt", nullable = false)
    private int elementWinCnt = 0;
}