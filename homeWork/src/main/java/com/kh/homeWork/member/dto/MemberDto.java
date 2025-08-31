package com.kh.homeWork.member.dto;


import com.kh.homeWork.member.entity.MemberEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {

    private Long no;
    private String userNick;

    public static MemberDto from(MemberEntity entity){
        MemberDto dto = new MemberDto();
        dto.no = entity.getNo();
        dto.userNick = entity.getUserNick();
        return dto;
    }

}
