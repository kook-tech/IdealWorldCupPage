package com.kch.persistence.repository;

import com.kch.persistence.entity.Board;
import com.kch.service.model.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByCategory(Category category);

}
