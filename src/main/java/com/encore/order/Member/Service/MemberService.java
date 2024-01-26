package com.encore.order.Member.Service;

import com.encore.order.Member.Domain.Member;
import com.encore.order.Member.Domain.Role;
import com.encore.order.Member.Dto.MemberListRes;
import com.encore.order.Member.Dto.MemberSaveReq;
import com.encore.order.Member.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<MemberListRes> findAll(MemberListRes memberListRes) {
        List<Member> members = memberRepository.findAll();
        List<MemberListRes> memberListResList = new ManagedList<>();
        for (Member m : members){
            MemberListRes memberListRes1 = new MemberListRes();
            memberListRes1.setId(m.getId());
            memberListRes1.setName(m.getName());
            memberListRes1.setRole(m.getRole().toString());
            memberListResList.add(memberListRes1);
        }
        return memberListResList;
    }
}
