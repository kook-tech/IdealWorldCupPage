package com.kch.service.service;

import com.kch.infrastructure.error.NotFoundException;
import com.kch.infrastructure.model.ResponseStatus;
import com.kch.persistence.entity.File;
import com.kch.persistence.entity.Game;
import com.kch.persistence.entity.User;
import com.kch.persistence.repository.FileRepository;
import com.kch.persistence.repository.GameRepository;
import com.kch.persistence.repository.UserRepository;
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
    private final UserRepository userRepository;
    private final FileRepository fileRepository;
    /*게임 생성 서비스
    param : 생성 게임 info*/
    @Transactional
    public void createGame(GameReqDTO.CREATE create){
        final User user = userRepository.findById(create.getUserId()).orElse(null);
        final File file = fileRepository.findById(create.getFileId()).orElse(null);

        final Game game = gameMapper.toGameEntity(create,user,file);
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
        final File file = fileRepository.findById(update.getFileId()).orElse(null);
        game.updateGame(update,file);
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
