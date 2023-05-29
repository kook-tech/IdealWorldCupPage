package com.kch.service.service;

import com.kch.infrastructure.error.NotFoundException;
import com.kch.infrastructure.model.ResponseStatus;
import com.kch.persistence.entity.File;
import com.kch.persistence.entity.Game;
import com.kch.persistence.entity.GameLog;
import com.kch.persistence.entity.User;
import com.kch.persistence.repository.GameLogRepository;
import com.kch.persistence.repository.GameRepository;
import com.kch.persistence.repository.UserRepository;
import com.kch.service.model.dtos.request.GameLogReqDTO;
import com.kch.service.model.dtos.response.GameLogResDTO;
import com.kch.service.model.mapper.GameLogMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GameLogService {
    private final GameLogRepository gameLogRepository;
    private final GameLogMapper gameLogMapper;
    private final UserRepository userRepository;
    private final GameRepository gameRepository;
    /*게임 기록 생성 서비스
    param : 생성 기록 info*/
    @Transactional
    public void createGameLog(GameLogReqDTO.CREATE create){
        final User user = userRepository.findById(create.getUserId()).orElse(null);
        final Game game = gameRepository.findById(create.getGameId()).orElse(null);

        final GameLog gameLog = gameLogMapper.toGameLogEntity(create,user,game);
        gameLogRepository.save(gameLog);
    }

    /*게임 기록 읽기 서비스
    param : 읽을 기록들의 유저 아이디(UserEntity's pk)*/
    public List<GameLogResDTO.READ> getGameLogByUserId(Long userId){
        final List<GameLog> gameLogList = gameLogRepository
                .findByUserId(userId);
        return gameLogMapper.toReadDtoList(gameLogList);
    }

    /*게임 기록 수정 필요 없음*/

    /*게임 기록 삭제 서비스
    param : 삭제 기록 아이디(gameLog's pk)*/
    @Transactional
    public void deleteGameLogByGameLogId(Long gameLogId){
        final GameLog gameLog = gameLogRepository
                .findById(gameLogId)
                .orElseThrow(()->new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        gameLogRepository.delete(gameLog);
    }


}
