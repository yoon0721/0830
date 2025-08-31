package com.kh.homeWork.member.api;

import com.kh.homeWork.board.dto.BoardDto;
import com.kh.homeWork.member.dto.MemberDto;
import com.kh.homeWork.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/member")
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService service;

    @PostMapping("join")
    public void join(@RequestBody MemberDto dto){
        service.join(dto);
    }
    @PostMapping("login")
    public MemberDto login(@RequestBody MemberDto dto, HttpSession session){
        MemberDto loginMember = service.login(dto);
        if (loginMember != null){
            session.setAttribute("memberLoginDto",loginMember);
        }

        return loginMember;

    }



}
