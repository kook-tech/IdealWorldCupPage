package com.kch.service.model.mapper;

import com.kch.persistence.entity.*;
import com.kch.service.model.dtos.request.GameElementReqDTO;
import com.kch.service.model.dtos.request.ReplyReqDTO;
import com.kch.service.model.dtos.response.GameElementResDTO;
import com.kch.service.model.dtos.response.ReplyResDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReplyMapper{
    @Mapping(target = "user", source = "user")
    @Mapping(target = "board", source = "board")
    @Mapping(target = "game", source = "game")
    Reply toReplyEntity(ReplyReqDTO.CREATE create, User user, Board board, Game game);
    List<Reply> toReplyEntityList(List<ReplyReqDTO.CREATE> createList);

    @Mapping(target = "userId", source = "reply.user", qualifiedByName = "mapUserToUserId")
    @Mapping(target = "replyId", source = "reply.id")
    ReplyResDTO.READ toReadDto(Reply reply);
    List<ReplyResDTO.READ> toReadDtoList(List<Reply> replyList);

    @Named("mapUserToUserId")
    default Long mapUserToUserId(User user) {
        return user.getId();
    }
}
