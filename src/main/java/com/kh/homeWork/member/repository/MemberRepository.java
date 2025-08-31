package com.kh.homeWork.member.repository;

import com.kh.homeWork.board.dto.BoardDto;
import com.kh.homeWork.board.entity.BoardEntity;
import com.kh.homeWork.member.dto.MemberDto;
import com.kh.homeWork.member.entity.MemberEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;


    public void join(MemberEntity entity) {
        em.persist(entity);
    }


    public MemberEntity findMemberByNo(Long writerNo) {
        return em.find(MemberEntity.class,writerNo);
    }

    public MemberEntity login(MemberDto dto) {
        String jpql = " select m from MemberEntity m where m.userNick = :a ";
        return em.createQuery(jpql,MemberEntity.class)
                .setParameter("a",dto.getUserNick())
                .getSingleResult();
    }
}
