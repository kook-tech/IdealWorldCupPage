package com.kch.service.model.mapper;

import com.kch.persistence.entity.Board;
import com.kch.persistence.entity.User;
import com.kch.service.model.dtos.request.BoardReqDTO;
import com.kch.service.model.dtos.response.BoardResDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BoardMapper {
    @Mapping(target = "user", source = "user")
    Board toBoardEntity(BoardReqDTO.CREATE create, User user);

    @Mapping(target = "boardId", source = "board.id")
    @Mapping(target = "userId", source = "board.user", qualifiedByName = "mapUserToUserId")
    BoardResDTO.READ toReadDto(Board board);

    List<BoardResDTO.READ> toReadDtoList(List<Board> boardList);

    @Named("mapUserToUserId")
    default Long mapUserToUserId(User user) {
        return user.getId();
    }
}
