package com.encore.order.Member.Dto;

import com.encore.order.Member.Domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberFindRes {
    private Long id;

    private String name;

    private String email;

    private String password;

    private String address;

    private Role role;

    private LocalDateTime createdTime;

    private int orderCount;
}
