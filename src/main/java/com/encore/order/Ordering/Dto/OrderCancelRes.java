package com.encore.order.Ordering.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderCancelRes {
    private Long id;
    private List<Long> itemId;
    private List<Long> count;
}
