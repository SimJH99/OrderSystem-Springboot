package com.encore.order.Member.Service;

import com.encore.order.Member.Domain.Member;
import com.encore.order.Member.Dto.MemberSaveReq;
import com.encore.order.Member.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    
    //회원가입 서비스
    public void memberSave(MemberSaveReq memberSaveReq) {
        Member member = Member.builder()
                .name(memberSaveReq.getName())
                .email(memberSaveReq.getEmail())
                .role(memberSaveReq.getRole())
                .address(memberSaveReq.getAddress())
                .password(memberSaveReq.getPassword())
                .orderings(new ArrayList<>())
                .build();
        memberRepository.save(member);
    }
}
