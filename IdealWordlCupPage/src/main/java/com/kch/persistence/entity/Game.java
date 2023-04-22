package com.kch.persistence.entity;

import com.kch.persistence.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "TBL_GAMES")
@ToString
@Getter
@Builder
@NoArgsConstructor
@AttributeOverride(
        name = "id",
        column = @Column(name = "game_id")
)
public class Game extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id", referencedColumnName = "id")
    private File fileId;

    @Column(name = "game_title", nullable = false, length = 20)
    private String gameTitle;

    @Lob
    @Column(name = "game_description")
    private String gameDescription;

    @Builder
    public Game(User user, File fileId, String gameTitle, String gameDescription) {
        this.user = user;
        this.fileId = fileId;
        this.gameTitle = gameTitle;
        this.gameDescription = gameDescription;
    }
}