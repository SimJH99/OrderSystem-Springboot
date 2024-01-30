package com.encore.order.Item.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemSaveReq {

    private String name;

    private int price;

    private int stockQuantity;
}
