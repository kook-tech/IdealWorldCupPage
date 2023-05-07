package com.kch.service.service;

import com.kch.infrastructure.error.NotFoundException;
import com.kch.infrastructure.model.ResponseStatus;
import com.kch.persistence.entity.GameElement;
import com.kch.persistence.repository.GameElementRepository;
import com.kch.service.model.dtos.request.GameElementReqDTO;
import com.kch.service.model.dtos.response.GameElementResDTO;
import com.kch.service.model.mapper.GameElementMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class GameElementService {
    private GameElementRepository gameElementRepository;
    private GameElementMapper gameElementMapper;

    /*게임 목록들 생성 서비스
    param : 생성 게임 목록들 info List*/
    @Transactional
    public void createGameElements(List<GameElementReqDTO.CREATE> createList){
        final List<GameElement> gameElementList = gameElementMapper.toGameElementEntityList(createList);
        gameElementRepository.saveAll(gameElementList);
    }

    /*게임 목록들 읽기 서비스
    param : 읽을 게임 목록들의 게임 아이디(GameEntity's pk)*/
    public List<GameElementResDTO.READ> getGameElementsByGameId(Long gameId){
        final List<GameElement> gameElementList = gameElementRepository
                .findByGameId(gameId);
        return gameElementMapper.toReadDtoList(gameElementList);
    }

    /*게임 목록 수정 서비스
    param : 수정 목록 아이디(GameElementEntity's pk), 수정 목록 info*/
    @Transactional
    public void updateGameElement(Long gameElementId, GameElementReqDTO.UPDATE update){
        GameElement gameElement = gameElementRepository
                .findById(gameElementId)
                .orElseThrow(()->new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        gameElement.updateGameElement(update);
    }

    /*게임 목록 한개 삭제 서비스
    param : 삭제 목록 아이디(GameElementEntity's pk)*/
    @Transactional
    public void deleteGameElementByElementId(Long gameElementId){
        final GameElement gameElement = gameElementRepository
                .findById(gameElementId)
                .orElseThrow(()->new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        gameElementRepository.delete(gameElement);
    }


}
