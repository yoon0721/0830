package com.kh.homeWork.board.entity;

import com.kh.homeWork.board.dto.BoardDto;
import com.kh.homeWork.member.dto.MemberDto;
import com.kh.homeWork.member.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "BOARD")
@Getter
@Setter
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(nullable = false,unique = true,length = 100)
    private String title;
    @Column(nullable = false,length = 100)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writerNo",nullable = false)
    private MemberEntity writer;

    public BoardEntity from(BoardDto dto,MemberEntity memberEntity){
        BoardEntity entity = new BoardEntity();
        entity.title = dto.getTitle();
        entity.content = dto.getContent();
        entity.writer = memberEntity;

        return entity;
    }




}
