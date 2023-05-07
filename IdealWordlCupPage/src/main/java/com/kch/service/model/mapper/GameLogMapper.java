package com.kch.service.model.mapper;

import com.kch.persistence.entity.GameElement;
import com.kch.persistence.entity.GameLog;
import com.kch.persistence.entity.Reply;
import com.kch.service.model.dtos.request.GameLogReqDTO;
import com.kch.service.model.dtos.request.ReplyReqDTO;
import com.kch.service.model.dtos.response.GameElementResDTO;
import com.kch.service.model.dtos.response.GameLogResDTO;
import com.kch.service.model.dtos.response.ReplyResDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GameLogMapper {
    GameLog toGameLogEntity(GameLogReqDTO.CREATE create);
    GameLogResDTO.READ toReadDto(GameLog gameLog);

    List<GameLogResDTO.READ> toReadDtoList(List<GameLog> gameLogList);

}
