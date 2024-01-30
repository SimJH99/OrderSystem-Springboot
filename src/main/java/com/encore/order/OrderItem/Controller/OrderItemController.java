package com.encore.order.OrderItem.Controller;

import com.encore.order.OrderItem.Dto.OrderItemListRes;
import com.encore.order.OrderItem.Service.OrderItemService;
import com.encore.order.Ordering.Domain.Ordering;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderItemController {

    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping("/orderitem/{id}")
    public List<OrderItemListRes> OrderItemList(@PathVariable Long id){
        return orderItemService.orderItemList(id);
    }
}