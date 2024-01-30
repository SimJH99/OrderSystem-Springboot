package com.encore.order.OrderItem.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemListRes {
    private Long orderId;
    private Long itemId;
    private int count;
}
