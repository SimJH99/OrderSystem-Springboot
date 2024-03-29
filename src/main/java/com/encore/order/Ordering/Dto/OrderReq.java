package com.encore.order.Ordering.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderReq {
    private Long memberId;
    private List<Long> itemId;
    private List<Long> count;
}
