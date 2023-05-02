package com.kch.persistence.repository;

import com.kch.persistence.entity.GameElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameElementRepository extends JpaRepository<GameElement, Long> {
}
