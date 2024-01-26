package com.encore.order.Member.Controller;

import com.encore.order.Member.Dto.MemberSaveReq;
import com.encore.order.Member.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
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
}
