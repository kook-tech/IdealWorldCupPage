package com.kch.service.service;

import com.kch.infrastructure.error.NotFoundException;
import com.kch.infrastructure.model.ResponseStatus;
import com.kch.persistence.entity.Board;
import com.kch.persistence.repository.BoardRepository;
import com.kch.service.model.dtos.request.BoardReqDTO;
import com.kch.service.model.dtos.response.BoardResDTO;
import com.kch.service.model.mapper.BoardMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BoardService {
    private BoardRepository boardRepository;
    private BoardMapper boardMapper;

    /*게시판 생성 서비스
    param : 생성 게시판 info*/
    @Transactional
    public void createBoard(BoardReqDTO.CREATE create){
        final Board board = boardMapper.toBoardEntity(create);
        boardRepository.save(board);
    }

    /*게시판 읽기 서비스
    param : 읽을 게시판 카테고리 아이디(CategoryEntity's pk)*/
    public List<BoardResDTO.READ> getBoardByCategoryId(Long categoryId){
        final List<Board> boardList = boardRepository
                .findByCategoryId(categoryId);

        return boardMapper.toReadDtoList(boardList);
    }

    /*게시판 수정 서비스
    param : 수정 게시판 아이디(pk), 수정 info*/
    @Transactional
    public void updateBoard(Long boardId, BoardReqDTO.UPDATE update){
        Board board = boardRepository
                .findById(boardId)
                .orElseThrow(()-> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        board.updateBoard(update);
    }

    /*게시판 삭제 서비스
    param : 삭제 게시판 아이디(pk)*/
    @Transactional
    public void deleteBoardByBoardId(Long boardId){
        final Board board = boardRepository
                .findById(boardId)
                .orElseThrow(()->new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        boardRepository.delete(board);
    }

}
