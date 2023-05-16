package com.kch.service.service;

import com.kch.persistence.entity.Reply;
import com.kch.persistence.repository.ReplyRepository;
import com.kch.service.model.ReplyDTOFactory;
import com.kch.service.model.ReplyMapperImpl;
import com.kch.service.model.dtos.request.ReplyReqDTO;
import com.kch.service.model.mapper.ReplyMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ReplyServiceTest {
    @InjectMocks
    private ReplyService replyService;

    @Mock
    private ReplyRepository replyRepository;

    @Mock
    private ReplyMapper replyMapper;



    @Test
    void createReply() {
        //given
        final ReplyReqDTO.CREATE create = ReplyDTOFactory.reply_of_board_create();
        final Reply reply = ReplyMapperImpl.toReplyEntity(create);

        given(replyMapper.toReplyEntity(any(ReplyReqDTO.CREATE.class))).willReturn(reply);

        //when,then
        assertDoesNotThrow(() -> replyService.createReply(create));
    }

    @Test
    void getReplysByBoardId() {

    }

    @Test
    void getReplysByGameId() {

    }

    @Test
    void updateReply() {

    }

    @Test
    void deleteReplyByReplyId() {
    }
}