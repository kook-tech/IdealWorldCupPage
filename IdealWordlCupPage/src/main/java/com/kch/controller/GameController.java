package com.kch.controller;

import com.kch.infrastructure.error.DuplicatedException;
import com.kch.infrastructure.error.NotFoundException;
import com.kch.infrastructure.model.ResponseFormat;
import com.kch.infrastructure.model.ResponseStatus;
import com.kch.persistence.entity.Game;
import com.kch.persistence.repository.GameRepository;
import com.kch.service.model.dtos.request.GameReqDTO;
import com.kch.service.model.dtos.response.GameResDTO;
import com.kch.service.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;

    /*게임 생성 컨트롤러
    param : 생성 게임 info*/
    @PostMapping
    public ResponseFormat<Void> createGame(@RequestParam @Validated GameReqDTO.CREATE create){
        try{
            gameService.createGame(create);
            return ResponseFormat.success(ResponseStatus.SUCCESS_CREATE);
        }catch(RuntimeException e){
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*게임 정보 조회 컨트롤러
    param : 조회 게임 GameId*/
    @GetMapping("/{gameId}")
    public ResponseFormat<GameResDTO.READ> getGameByGameId(@PathVariable(name="gameId") Long gameId){
        try{
            return ResponseFormat.successWithData(ResponseStatus.SUCCESS_OK, gameService.getGameByGameId(gameId));
        }catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*게임 정보 수정 컨트롤러
    param : 수정 게임 GameId, 수정 게임 Info*/
    @PutMapping("/{gameId}")
    public ResponseFormat<Void> updateGameBygameId(@PathVariable(name = "gameId") Long gameId, GameReqDTO.UPDATE update){
        try{
            gameService.updateGame(gameId, update);
            return ResponseFormat.success(ResponseStatus.SUCCESS_NO_CONTENT);
        }catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*게임 삭제 컨트롤러
    param : 삭제 게임 gameId*/
    @DeleteMapping("/{gameId}")
    public ResponseFormat<Void> deleteGameByGameId(@PathVariable(name="gameId") Long gameId){
        try {
            gameService.deleteGameByGameId(gameId);
            return ResponseFormat.success(ResponseStatus.SUCCESS_NO_CONTENT);
        } catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }
}