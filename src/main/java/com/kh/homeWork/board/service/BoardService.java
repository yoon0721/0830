package com.kh.homeWork.board.service;

import com.kh.homeWork.board.dto.BoardDto;
import com.kh.homeWork.board.entity.BoardEntity;
import com.kh.homeWork.board.repository.BoardRepository;
import com.kh.homeWork.member.entity.MemberEntity;
import com.kh.homeWork.member.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository repository;
    private final MemberRepository memberRepository;

    public Long insert(BoardDto dto) {
        MemberEntity memberEntity = memberRepository.findMemberByNo(dto.getWriterNo());
        BoardEntity entity = new BoardEntity();
        entity.setWriter(memberEntity);
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        repository.insert(entity);
        return entity.getNo();

    }

    public List<BoardDto> findBoardAll() {
        List<BoardEntity> entityList = repository.findBoardAll();
        return entityList.stream().map(BoardDto::from).toList();
    }
}
