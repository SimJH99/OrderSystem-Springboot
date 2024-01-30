package com.encore.order.Member.Controller;

import com.encore.order.Member.Domain.Member;
import com.encore.order.Member.Dto.MemberFindRes;
import com.encore.order.Member.Dto.MemberListRes;
import com.encore.order.Member.Dto.MemberSaveReq;
import com.encore.order.Member.Service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    //회원가입
    @PostMapping("/member/create")
    public String MemberSave(@RequestBody MemberSaveReq memberSaveReq){
        memberService.memberSave(memberSaveReq);
        return "Ok";
    }

    //회원 목록 조회
    @GetMapping("/member/list")
    public List<MemberListRes> MemberList(MemberListRes memberListRes){
        List<MemberListRes> members = memberService.findAll(memberListRes);
        return members;
    }

    //특정 회원 조회
    @GetMapping("/member/find/{id}")
    public MemberFindRes memberFind(@PathVariable Long id){
        MemberFindRes memberFindRes = memberService.findDetail(id);
        return memberFindRes;
    }
}
