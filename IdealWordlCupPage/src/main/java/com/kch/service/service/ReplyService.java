package com.kch.service.service;

import com.kch.infrastructure.error.NotFoundException;
import com.kch.infrastructure.model.ResponseStatus;
import com.kch.persistence.entity.Board;
import com.kch.persistence.entity.Game;
import com.kch.persistence.entity.Reply;
import com.kch.persistence.entity.User;
import com.kch.persistence.repository.BoardRepository;
import com.kch.persistence.repository.GameRepository;
import com.kch.persistence.repository.ReplyRepository;
import com.kch.persistence.repository.UserRepository;
import com.kch.service.model.dtos.request.ReplyReqDTO;
import com.kch.service.model.dtos.response.ReplyResDTO;
import com.kch.service.model.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final ReplyMapper replyMapper;
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final GameRepository gameRepository;
    /*댓글 작성 서비스
    param : 작성 댓글 info*/
    @Transactional
    public void createReply(ReplyReqDTO.CREATE create) {
        final User user = userRepository.findById(create.getUserId()).orElse(null);
        final Game game = gameRepository.findById(create.getGameId()).orElse(null);;
        final Board board = boardRepository.findById(create.getBoardId()).orElse(null);


        final Reply reply = replyMapper.toReplyEntity(create, user, board, game);
        replyRepository.save(reply);
    }

    /*게시글 댓글들 읽기 서비스
    param : 게시글 아이디(BoardEntity's pk)*/
    public List<ReplyResDTO.READ> getRepliesByBoardId(Long boardId) {
        final List<Reply> replyList = replyRepository
                .findByBoardId(boardId);

        return replyMapper.toReadDtoList(replyList);
    }

    /*게임 댓글들 읽기 서비스
    param : 게임 아이디(GameEntity's pk)*/
    public List<ReplyResDTO.READ> getRepliesByGameId(Long gameId) {
        final List<Reply> replyList = replyRepository
                .findByGameId(gameId);

        return replyMapper.toReadDtoList(replyList);
    }

    /*댓글 수정 서비스
    param : 수정 댓글 info*/
    @Transactional
    public void updateReply(Long replyId, ReplyReqDTO.UPDATE update) {
        Reply reply = replyRepository
                .findById(replyId)
                .orElseThrow(() -> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        reply.updateReply(update);
    }

    /*댓글 삭제 서비스
    param : 삭제 댓글 id(ReplyEntity's pk)*/
    @Transactional
    public void deleteReplyByReplyId(Long replyId) {
        final Reply reply = replyRepository
                .findById(replyId)
                .orElseThrow(() -> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        replyRepository.delete(reply);
    }

}
