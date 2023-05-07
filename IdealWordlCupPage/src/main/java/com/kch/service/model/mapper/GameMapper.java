package com.kch.service.model.mapper;

import com.kch.persistence.entity.Game;
import com.kch.service.model.dtos.request.GameReqDTO;
import com.kch.service.model.dtos.response.GameResDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GameMapper {
    Game toGameEntity(GameReqDTO.CREATE create);
    GameResDTO.READ toReadDto(Game game);

}
