package com.kh.homeWork.board.dto;


import com.kh.homeWork.board.entity.BoardEntity;
import com.kh.homeWork.member.dto.MemberDto;
import com.kh.homeWork.member.entity.MemberEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {

    private Long no;
    private String title;
    private String content;
    private Long writerNo;
    private String writerNick;

    public static BoardDto from(BoardEntity entity){
        BoardDto dto = new BoardDto();
        dto.no = entity.getNo();
        dto.title = entity.getTitle();
        dto.content = entity.getContent();
        dto.writerNo = entity.getWriter().getNo();
        dto.writerNick = entity.getWriter().getUserNick();
        return dto;
    }

}
