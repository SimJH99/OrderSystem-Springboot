package com.encore.order.Member.Service;

import com.encore.order.Member.Domain.Member;
import com.encore.order.Member.Domain.Role;
import com.encore.order.Member.Dto.MemberFindRes;
import com.encore.order.Member.Dto.MemberListRes;
import com.encore.order.Member.Dto.MemberSaveReq;
import com.encore.order.Member.Repository.MemberRepository;
import com.encore.order.Ordering.Domain.Ordering;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member findById(Long id){
        Member member = memberRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return member;
    }

    public MemberFindRes findDetail(Long id){
        Member member = memberRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        MemberFindRes memberFindRes = MemberFindRes.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .password(member.getPassword())
                .createdTime(member.getCreatedTime())
                .role(member.getRole())
                .orderCount(member.getOrderings().size())
                .build();
        return memberFindRes;
    }

    //회원가입 서비스
    public void memberSave(MemberSaveReq memberSaveReq) {
        List<Ordering> orderings = new ArrayList<>();
        Member member = Member.builder()
                .name(memberSaveReq.getName())
                .email(memberSaveReq.getEmail())
                .role(memberSaveReq.getRole())
                .address(memberSaveReq.getAddress())
                .password(memberSaveReq.getPassword())
                .orderings(orderings)
                .build();
        memberRepository.save(member);
    }

    //회원 목록 조회
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
