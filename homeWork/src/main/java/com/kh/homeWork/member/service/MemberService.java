package com.kh.homeWork.member.service;

import com.kh.homeWork.member.dto.MemberDto;
import com.kh.homeWork.member.entity.MemberEntity;
import com.kh.homeWork.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository repository;

    public void join(MemberDto dto) {
        MemberEntity entity = MemberEntity.from(dto);
        repository.join(entity);
    }

    public MemberDto login(MemberDto dto) {
        MemberEntity entity = repository.login(dto);
        return MemberDto.from(entity);
    }

}
