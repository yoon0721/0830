package com.kh.homeWork.board.repository;

import com.kh.homeWork.board.dto.BoardDto;
import com.kh.homeWork.board.entity.BoardEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final EntityManager em;

    public void insert(BoardEntity entity) {
        em.persist(entity);
    }


    public List<BoardEntity> findBoardAll() {
        String jpql = " select b from BoardEntity b join fetch b.writer ";
        return em
                .createQuery(jpql,BoardEntity.class)
                .getResultList();
    }

}
