package com.kch.service.model;

import com.kch.service.model.dtos.request.ReplyReqDTO;
import com.kch.service.model.dtos.response.ReplyResDTO;

public class ReplyDTOFactory {

    public static ReplyReqDTO.CREATE reply_of_board_create() {
        return ReplyReqDTO.CREATE.builder()
                .content("댓글1")
                .boardId(1L)
                .userId(1L)
                .build();
    }

    public static ReplyReqDTO.UPDATE reply_update(){
        return ReplyReqDTO.UPDATE.builder()
                .replyId(1L)
                .content("댓글1수정")
                .build();
    }

    public static ReplyResDTO.READ reply_read(){
        return ReplyResDTO.READ.builder()
                .userId(1L)
                .content("댓글 읽기")
                .build();
    }
}
