package com.kch.service.model.mapper;

import com.kch.persistence.entity.Board;
import com.kch.persistence.entity.File;
import com.kch.persistence.entity.Game;
import com.kch.persistence.entity.User;
import com.kch.service.model.dtos.request.BoardReqDTO;
import com.kch.service.model.dtos.request.GameReqDTO;
import com.kch.service.model.dtos.response.GameResDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface GameMapper{

    @Mapping(target = "user", source = "user")
    @Mapping(target = "file", source = "file")
    Game toGameEntity(GameReqDTO.CREATE create, User user, File file);

    @Mapping(target = "gameId", source = "game.id")
//    @Mapping(target = "fileId", source = "game.file", qualifiedByName = "mapFileToFileId")
//    @Mapping(target = "userId", source = "game.user", qualifiedByName = "mapUserToUserId")
    // file과 user가 null일 경우 아래 default 매핑 메서드를 사용하는 과정에서 오류가 발생함.
    // 애초에 file과 user가 빈채로 game을 생성할 일은 없으니까 상관없을 거라고 생각함. 일단 주석처리
    GameResDTO.READ toReadDto(Game game);

    @Named("mapFileToFileId")
    default Long mapFileToFileId(File file) {
        return file.getId();
    }
    @Named("mapUserToUserId")
    default Long mapUserToUserId(User user) {
        return user.getId();
    }
}
