package com.encore.order.Member.Controller;

import com.encore.order.Member.Domain.Member;
import com.encore.order.Member.Dto.MemberListRes;
import com.encore.order.Member.Dto.MemberSaveReq;
import com.encore.order.Member.Service.MemberService;
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
    @ResponseBody
    public String MemberSave(MemberSaveReq memberSaveReq){
        memberService.memberSave(memberSaveReq);
        return "Ok";
    }

    //회원 목록 조회
    @GetMapping("/member/list")
    @ResponseBody
    public List<MemberListRes> MemberList(MemberListRes memberListRes){
        List<MemberListRes> members = memberService.findAll(memberListRes);
        return members;
    }

    @GetMapping("/member/find/{id}")
    @ResponseBody
    public Member memberFind(@PathVariable Long id){
        return memberService.findById(id);
    }
}
