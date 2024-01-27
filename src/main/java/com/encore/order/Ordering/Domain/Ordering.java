package com.encore.order.Ordering.Domain;

import com.encore.order.Member.Domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Ordering {
    //PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //회원 객체
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "member_id")
    private Member member;

    //주문 상태
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    //생성 시간
    @CreationTimestamp
    private LocalDateTime createdTime;

    //수정 시간 : 상품 취소할때 update기록
    @UpdateTimestamp
    private LocalDateTime updatedTime;
}
