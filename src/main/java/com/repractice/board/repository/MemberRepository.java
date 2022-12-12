package com.repractice.board.repository;

import com.repractice.board.domain.model.aggregates.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // 기본 제공 JPA 메소드(save, findById, findAll 등등 말고 필요한 로직 작성
}
