package com.kch.service.service;

import com.kch.infrastructure.error.NotFoundException;
import com.kch.infrastructure.model.ResponseStatus;
import com.kch.persistence.entity.Board;
import com.kch.persistence.entity.User;
import com.kch.persistence.repository.BoardRepository;
import com.kch.persistence.repository.UserRepository;
import com.kch.service.model.dtos.request.BoardReqDTO;
import com.kch.service.model.dtos.response.BoardResDTO;
import com.kch.service.model.enums.Category;
import com.kch.service.model.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;
    private final UserRepository userRepository;
    /*게시판 생성 서비스
    param : 생성 게시판 info*/
    @Transactional
    public void createBoard(BoardReqDTO.CREATE create){
        final User user = userRepository.findById(create.getUserId()).orElse(null);

        final Board board = boardMapper.toBoardEntity(create, user);
        boardRepository.save(board);
    }

    /*게시판 읽기 서비스
    param : 읽을 게시판 카테고리 아이디(CategoryEntity's pk)*/
    public List<BoardResDTO.READ> getBoardByCategory(Category category){
        final List<Board> boardList = boardRepository
                .findByCategory(category);
//        System.out.println(boardList.get(0).getUser().getId());
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
