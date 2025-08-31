package com.kh.homeWork.board.api;

import com.kh.homeWork.board.dto.BoardDto;
import com.kh.homeWork.board.service.BoardService;
import com.kh.homeWork.member.dto.MemberDto;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardService service;

    @PostMapping("insert")
    public Long insert(@RequestBody BoardDto dto, HttpSession session){
        MemberDto memberLoginDto =  (MemberDto) session.getAttribute("memberLoginDto");
        dto.setWriterNo(memberLoginDto.getNo());
//        Long loginMemberNo = 1L;
//        dto.setWriterNo(loginMemberNo);
        return service.insert(dto);
    }
    @GetMapping("selectAll")
    public List<BoardDto> findBoardAll(){
        return service.findBoardAll();
    }

}
