package com.kch.service.model.mapper;

import com.kch.persistence.entity.Board;
import com.kch.persistence.entity.Category;
import com.kch.service.model.dtos.request.BoardReqDTO;
import com.kch.service.model.dtos.response.BoardResDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BoardMapper {
    Board toBoardEntity(BoardReqDTO.CREATE create);
    BoardResDTO.READ toReadDto(Board board);

    List<BoardResDTO.READ> toReadDtoList(List<Board> boardList);
}
