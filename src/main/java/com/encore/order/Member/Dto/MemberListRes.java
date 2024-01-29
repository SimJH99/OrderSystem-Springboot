package com.encore.order.Member.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberListRes {
    private Long id;
    private String name;
    private String role;
}
