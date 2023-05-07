package com.kch.persistence.repository;

import com.kch.persistence.entity.GameElement;
import com.kch.persistence.entity.GameLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameLogRepository extends JpaRepository<GameLog, Long> {
    List<GameLog> findByUserId(Long userId);
}
