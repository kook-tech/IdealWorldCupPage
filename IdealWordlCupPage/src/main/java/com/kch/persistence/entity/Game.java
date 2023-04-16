package com.kch.persistence.entity;

import com.kch.persistence.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "TBL_GAMES")
public class Game extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id", referencedColumnName = "id")
    private File file;

    @Column(name = "game_title", nullable = false, length = 20)
    private String gameTitle;

    @Lob
    @Column(name = "game_description")
    private String gameDescription;

}