package com.encore.order.Member.Dto;

import com.encore.order.Member.Domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberSaveReq {
    //회원 이름
    private String name;

    //이메일
    private String email;

    //비밀번호
    private String password;

    //주소
    private String address;

    //회원 권환(관리자, 회원)
    private Role role;
}
