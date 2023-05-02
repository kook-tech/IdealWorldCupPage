package com.kch.persistence.entity;

import com.kch.persistence.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TBL_GAMES")
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AttributeOverride(
        name = "id",
        column = @Column(name = "game_id")
)
public class Game extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id", referencedColumnName = "id")
    private File fileId;

    @Column(name = "game_title", nullable = false, length = 20)
    private String gameTitle;

    @Lob
    @Column(name = "game_description", nullable = true)
    private String gameDescription;

    @Builder
    private Game(User userId, File fileId, String gameTitle, String gameDescription) {
        this.userId = userId;
        this.fileId = fileId;
        this.gameTitle = gameTitle;
        this.gameDescription = gameDescription;
    }
}