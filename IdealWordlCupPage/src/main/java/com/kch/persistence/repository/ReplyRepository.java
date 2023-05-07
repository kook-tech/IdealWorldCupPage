package com.kch.persistence.repository;

import com.kch.persistence.entity.GameElement;
import com.kch.persistence.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findByBoardId(Long boardId);
    List<Reply> findByGameId(Long gameId);

    void deleteByBoardId(Long boardId);
    void deleteByGameId(Long GameId);
}
