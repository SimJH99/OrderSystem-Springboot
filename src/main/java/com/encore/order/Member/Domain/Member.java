package com.encore.order.Member.Domain;

import com.encore.order.Item.Domain.Role;
import com.encore.order.Ordering.Domain.Ordering;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {
    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //회원 이름
    @Column(nullable = false)
    private String name;

    //이메일
    @Column(nullable = false, unique = true)
    private String email;

    //비밀번호
    @Column(nullable = false)
    private String password;

    //주소
    private String address;

    //회원 권환(관리자, 회원)
    @Column(nullable = false)
    private Role role;

    //생성시간
    @CreationTimestamp
    private LocalDateTime createdTime;

    //수정 시간
    @UpdateTimestamp
    private LocalDateTime updatedTime;

    //주문 객체
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ordering> orderings;
}
