package com.kch.controller;

import com.kch.infrastructure.error.NotFoundException;
import com.kch.infrastructure.model.ResponseFormat;
import com.kch.infrastructure.model.ResponseStatus;
import com.kch.service.model.dtos.request.GameElementReqDTO;
import com.kch.service.model.dtos.request.GameReqDTO;
import com.kch.service.model.dtos.request.UserReqDTO;
import com.kch.service.model.dtos.response.GameElementResDTO;
import com.kch.service.model.dtos.response.GameResDTO;
import com.kch.service.service.GameElementService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gameElements")
@RequiredArgsConstructor
public class GameElementController {
    private final GameElementService gameElementService;

    /*목록들 생성 컨트롤러
    param : 생성 목록 info List*/
    @PostMapping
    public ResponseFormat<Void> createGameElements(@RequestParam @Validated List<GameElementReqDTO.CREATE> createList){
        try{
            gameElementService.createGameElements(createList);
            return ResponseFormat.success(ResponseStatus.SUCCESS_CREATE);
        }catch(RuntimeException e){
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*목록들 조회 컨트롤러
    param : 조회 목록들의 소속 게임 아이디 (GameEntity's pk)GameId*/
    @GetMapping("/{gameId}")
    public ResponseFormat<List<GameElementResDTO.READ>> getGameElementsByGameId(@PathVariable(name="gameId") Long gameId){
        try{
            return ResponseFormat.successWithData(ResponseStatus.SUCCESS_OK, gameElementService.getGameElementsByGameId(gameId));
        }catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

    /*목록 수정 컨트롤러
    param : 수정 목록 elementId, 수정 목록 Info*/
    @PutMapping("/{gameId}")
    public ResponseFormat<Void> updateGameElmentByGameElementId(@PathVariable(name = "gameId") Long gameElementId, GameElementReqDTO.UPDATE update){
        try{
            gameElementService.updateGameElement(gameElementId, update);
            return ResponseFormat.success(ResponseStatus.SUCCESS_NO_CONTENT);
        }catch (NotFoundException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_NOT_FOUND);
        } catch (RuntimeException e) {
            return ResponseFormat.error(ResponseStatus.FAIL_BAD_REQUEST);
        }
    }

}
