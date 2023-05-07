package com.kch.service.model.mapper;

import com.kch.persistence.entity.GameElement;
import com.kch.persistence.entity.Reply;
import com.kch.service.model.dtos.request.GameElementReqDTO;
import com.kch.service.model.dtos.request.ReplyReqDTO;
import com.kch.service.model.dtos.response.GameElementResDTO;
import com.kch.service.model.dtos.response.ReplyResDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReplyMapper {
    Reply toReplyEntity(ReplyReqDTO.CREATE create);
    ReplyResDTO toReadDto(Reply reply);


    List<Reply> toReplyEntityList(List<ReplyReqDTO.CREATE> createList);
    List<ReplyResDTO.READ> toReadDtoList(List<Reply> replyList);
}
