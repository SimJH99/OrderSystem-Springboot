package com.encore.order.Ordering.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class OrderReq {
    private Long memberId;
    private List<Long> itemId;
    private List<Long> count;
}
