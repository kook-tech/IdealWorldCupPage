package com.kch.controller;

import com.kch.infrastructure.error.NotFoundException;
import com.kch.infrastructure.model.ResponseFormat;
import com.kch.infrastructure.model.ResponseStatus;
import com.kch.persistence.entity.Board;
import com.kch.service.model.dtos.request.BoardReqDTO;
import com.kch.service.model.dtos.response.BoardResDTO;
import com.kch.service.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    /*게시판 생성 컨트롤러
    param : 생성 게시판 info */
    @PostMapping
    public ResponseFormat<Void> createBoard(@RequestParam BoardReqDTO.CREATE create) {
        try {
            boardService.createBoard(create);
            return ResponseFormat.success(ResponseStatus.SUCCESS_CREATE);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*게시판 읽기 컨트롤러
    param : 읽을 게시판 카테고리 아이디(CategoryEntity's pk) info */
    @GetMapping("/{categoryId}")
    public ResponseFormat<List<BoardResDTO.READ>> getBoardByBoardId(@PathVariable(name = "categoryId") Long categoryId) {
        try {
            return ResponseFormat.successWithData(ResponseStatus.SUCCESS_OK, boardService.getBoardByCategoryId(categoryId));
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*게시판 수정 컨트롤러
    param : 수정 게시판 BoardId, 수정 게시판 info */
    @PutMapping("/{boardId}")
    public ResponseFormat<Void> updateBoardByBoardId(@PathVariable(name = "boardId") Long boardId, BoardReqDTO.UPDATE update) {
        try {
            boardService.updateBoard(boardId, update);
            return ResponseFormat.success(ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*게시판 삭제 컨트롤러
    param : 삭제 게시판 BoardId*/
    @DeleteMapping
    public ResponseFormat<Void> deleteBoardByBoardId(@PathVariable(name = "boardId") Long boardId) {
        try {
            boardService.deleteBoardByBoardId(boardId);
            return ResponseFormat.success(ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }


}
