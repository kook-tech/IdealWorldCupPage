package com.kch.persistence.repository;

import com.kch.persistence.entity.GameLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameLogRepository extends JpaRepository<GameLog, Long> {
}
