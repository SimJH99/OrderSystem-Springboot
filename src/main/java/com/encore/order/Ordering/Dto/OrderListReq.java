package com.encore.order.Ordering.Dto;

import com.encore.order.Member.Domain.Member;
import com.encore.order.Ordering.Domain.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderListReq {

    private Long id;

    private Member member;

    private String orderStatus;

    private LocalDateTime createdTime;
}
