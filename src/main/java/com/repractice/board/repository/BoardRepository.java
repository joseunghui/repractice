package com.repractice.board.repository;

import com.repractice.board.domain.model.aggregates.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    // 리포지토리 작성
}
