package com.kch.service.model.mapper;

import com.kch.persistence.entity.GameElement;
import com.kch.service.model.dtos.request.GameElementReqDTO;
import com.kch.service.model.dtos.response.GameElementResDTO;
import com.kch.service.model.dtos.response.GameResDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GameElementMapper {
    GameElement toGameElementEntity(GameElementReqDTO.CREATE create);
    GameElementResDTO.READ toReadDto(GameElement gameElement);

    List<GameElement> toGameElementEntityList(List<GameElementReqDTO.CREATE> createList);
    List<GameElementResDTO.READ> toReadDtoList(List<GameElement> gameElementList);
}
