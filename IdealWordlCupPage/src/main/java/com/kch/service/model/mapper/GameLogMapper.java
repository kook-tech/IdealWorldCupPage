package com.kch.service.model.mapper;

import com.kch.persistence.entity.*;
import com.kch.service.model.dtos.request.GameLogReqDTO;
import com.kch.service.model.dtos.request.ReplyReqDTO;
import com.kch.service.model.dtos.response.GameElementResDTO;
import com.kch.service.model.dtos.response.GameLogResDTO;
import com.kch.service.model.dtos.response.ReplyResDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GameLogMapper {
    @Mapping(target = "user", source = "user")
    @Mapping(target = "game", source = "game")
    GameLog toGameLogEntity(GameLogReqDTO.CREATE create, User user, Game game);

    @Mapping(target = "userId", source = "gameLog.user", qualifiedByName = "mapUserToUserId")
    @Mapping(target = "gameId", source = "gameLog.game", qualifiedByName = "mapGameToGameId")
    GameLogResDTO.READ toReadDto(GameLog gameLog);
    List<GameLogResDTO.READ> toReadDtoList(List<GameLog> gameLogList);
    @Named("mapUserToUserId")
    default Long mapUserToUserId(User user) {
        return user.getId();
    }
    @Named("mapGameToGameId")
    default Long mapGameToGameId(Game game) {
        return game.getId();
    }
}
