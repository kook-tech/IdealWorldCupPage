package com.kch.persistence.entity;

import com.kch.persistence.BaseEntity;
import com.kch.service.model.dtos.request.GameReqDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id", referencedColumnName = "file_id")
    private File file;

    @Column(name = "game_title", nullable = false, length = 20)
    private String gameTitle;

    @Column(name = "game_description", nullable = true)
    private String gameDescription;

    //게임을 통해 게임 기록을 조회할 필요는 없으니 일대다관계 연관필드 pass

/*    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY)
    private List<Reply> replyList;*/

/*    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY)
    private List<GameElement> gameElementList;*/
    //둘다 초기화는 할 필요 없다. 초기화하지 않아도 연관필드를 통해 조회가 가능하고, 항상 연관필드를 필요로하는 경우가 아니기 때문이다.
    //예를 들어 메인페이지에서 게임리스트를 보여줄때 게임요소들의 정보를 가져오게되면 쓰지도 않으면서 엄청난 부하가 걸림.

    @Builder
    private Game(User user, File file, String gameTitle, String gameDescription) {
        this.user = user;
        this.file = file;
        this.gameTitle = gameTitle;
        this.gameDescription = gameDescription;
    }

    public void updateGame(GameReqDTO.UPDATE update,File file){
        this.file = file;
        this.gameTitle = update.getGameTitle();
        this.gameDescription = update.getGameDescription();
    }
}