package com.kh.homeWork.member.entity;

import com.kh.homeWork.member.dto.MemberDto;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "MEMBER")
@Getter
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(nullable = false, unique = true, length = 40)
    private String userNick;

    public static MemberEntity from(MemberDto dto){
        MemberEntity entity = new MemberEntity();
        entity.userNick = dto.getUserNick();
        return entity;
    }

}
