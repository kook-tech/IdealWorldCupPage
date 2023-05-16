package com.kch.service.service;

import com.kch.infrastructure.error.NotFoundException;
import com.kch.infrastructure.model.ResponseStatus;
import com.kch.persistence.entity.Game;
import com.kch.persistence.repository.GameRepository;
import com.kch.service.model.dtos.request.GameReqDTO;
import com.kch.service.model.dtos.response.GameResDTO;
import com.kch.service.model.mapper.GameMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GameService {
    private final GameRepository gameRepository;
    private final GameMapper gameMapper;


    /*게임 생성 서비스
    param : 생성 게임 info*/
    @Transactional
    public void createGame(GameReqDTO.CREATE create){
        final Game game = gameMapper.toGameEntity(create);
        gameRepository.save(game);
    }

    /*게임 정보 읽기 서비스
    param : 읽을 게임 아이디(pk)*/
    public GameResDTO.READ getGameByGameId(Long gameId){
        final Game game = gameRepository
                .findById(gameId)
                .orElseThrow(()->new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        return gameMapper.toReadDto(game);
    }
    /*게임 정보 수정 서비스
    param : 수정 게임 아이디(pk), 수정 info*/
    @Transactional
    public void updateGame(Long gameId, GameReqDTO.UPDATE update){
        Game game = gameRepository
                .findById(gameId)
                .orElseThrow(()->new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        game.updateGame(update);
    }
    /*게임 삭제 서비스
    param : 삭제 게임 아이디(pk)*/
    @Transactional
    public void deleteGameByGameId(Long gameId){
        final Game game = gameRepository
                .findById(gameId)
                .orElseThrow(()->new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        gameRepository.delete(game);
    }
}
