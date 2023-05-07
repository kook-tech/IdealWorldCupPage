package com.kch.persistence.repository;

import com.kch.persistence.entity.GameElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameElementRepository extends JpaRepository<GameElement, Long> {


    List<GameElement> findByGameId(Long gameId);
    void deleteByGameId(Long GameId);
}
