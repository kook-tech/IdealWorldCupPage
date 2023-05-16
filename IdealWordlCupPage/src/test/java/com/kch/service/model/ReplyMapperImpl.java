package com.kch.service.model;

import com.kch.persistence.entity.Board;
import com.kch.persistence.entity.Reply;
import com.kch.persistence.entity.User;
import com.kch.service.model.dtos.request.ReplyReqDTO;

public class ReplyMapperImpl {

    public static Reply toReplyEntity(ReplyReqDTO.CREATE create){
        if(create == null)
            return null;
        else{
            Reply.ReplyBuilder reply = Reply.builder();
            reply.board(Board.builder().build())
                    .user(User.builder().build())
                    .content(create.getContent())
                    .build();

            return reply.build();
        }
    }
}
