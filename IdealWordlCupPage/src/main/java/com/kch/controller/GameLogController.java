package com.kch.controller;

import com.kch.infrastructure.error.NotFoundException;
import com.kch.infrastructure.model.ResponseFormat;
import com.kch.infrastructure.model.ResponseStatus;
import com.kch.service.model.dtos.request.GameLogReqDTO;
import com.kch.service.model.dtos.response.GameLogResDTO;
import com.kch.service.service.GameLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gameLogs")
public class GameLogController {
    private final GameLogService gameLogService;

    /*기록 생성 컨트롤러
    param : 생성 기록 info*/
    @PostMapping
    public ResponseFormat<Void> createGame(@RequestBody @Validated GameLogReqDTO.CREATE create) {
        try {
            gameLogService.createGameLog(create);
            return ResponseFormat.success(ResponseStatus.SUCCESS_CREATE);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*기록 조회 컨트롤러
    param : 조회 기록들의 소속 유저 아이디 (UserEntity's pk) UserId*/
    @GetMapping("/{userId}")
    public ResponseFormat<List<GameLogResDTO.READ>> getGameLogByGameId(@PathVariable(name = "userId") Long userId) {
        try {
            return ResponseFormat.successWithData(ResponseStatus.SUCCESS_OK, gameLogService.getGameLogByUserId(userId));
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*기록 삭제 컨트롤러
    param : 삭제 기록 gameLogId*/
    @DeleteMapping("/{gameLogId}")
    public ResponseFormat<Void> deleteGameLogByGameLogId(@PathVariable(name = "gameLogId") Long gameLogId) {
        try {
            gameLogService.deleteGameLogByGameLogId(gameLogId);
            return ResponseFormat.success(ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }
}

