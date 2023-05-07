package com.kch.controller;

import com.kch.infrastructure.error.NotFoundException;
import com.kch.infrastructure.model.ResponseFormat;
import com.kch.infrastructure.model.ResponseStatus;
import com.kch.service.model.dtos.request.ReplyReqDTO;
import com.kch.service.model.dtos.response.ReplyResDTO;
import com.kch.service.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/replys")
public class ReplyController {
    private final ReplyService replyService;

    /*댓글 작성 컨트롤러
    param : 작성 댓글 info*/
    @PostMapping
    public ResponseFormat<Void> createReply(@RequestParam @Validated ReplyReqDTO.CREATE create) {
        try {
            replyService.createReply(create);
            return ResponseFormat.success(ResponseStatus.SUCCESS_CREATE);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*게임 댓글 조회 컨트롤러
    param : 댓글들 소속 게임 gameId*/
    @GetMapping("/{gameId}")
    public ResponseFormat<List<ReplyResDTO.READ>> getReplysByGameId(@PathVariable(name = "gameId") Long gameId) {
        try {
            return ResponseFormat.successWithData(ResponseStatus.SUCCESS_OK, replyService.getReplysByGameId(gameId));
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*게시판 댓글 조회 컨트롤러
    param : 댓글들 소속 게시판 boardId*/
    @GetMapping("/{boardId}")
    public ResponseFormat<List<ReplyResDTO.READ>> getReplysByBoardId(@PathVariable(name = "boardId") Long boardId) {
        try {
            return ResponseFormat.successWithData(ResponseStatus.SUCCESS_OK, replyService.getReplysByBoardId(boardId));
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*댓글  수정 컨트롤러
    param : 수정 댓글 Info*/
    @PutMapping
    public ResponseFormat<Void> updateReplyByReplyId(ReplyReqDTO.UPDATE update) {
        try {
            replyService.updateReply(update);
            return ResponseFormat.success(ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*댓글 삭제 컨트롤러
    param : 삭제 댓글 replyId*/
    @DeleteMapping("/{replyId}")
    public ResponseFormat<Void> deleteReplyByReplyId(@PathVariable(name = "replyId") Long replyId) {
        try {
            replyService.deleteReplyByReplyId(replyId);
            return ResponseFormat.success(ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

}
