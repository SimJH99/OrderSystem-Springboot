package com.encore.order.Ordering.Controller;

import com.encore.order.Ordering.Domain.Ordering;
import com.encore.order.Ordering.Dto.OrderListReq;
import com.encore.order.Ordering.Dto.OrderReq;
import com.encore.order.Ordering.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //주문목록조회
    @GetMapping("/orders")
    public List<OrderListReq> orderList(OrderListReq orderListReq){
        List<OrderListReq> orderListReqs = orderService.orderList(orderListReq);
        return orderListReqs;
    }

    //주문등록
    @PostMapping("/order/new")
    public String orderNew(@RequestBody OrderReq orderReq){
        orderService.save(orderReq);
        return "Ok";
    }
    
    //주문취소
    @PostMapping("/order/{id}/cancel")
    public String orderCancel(@PathVariable Long id){
        orderService.orderCancel(id);
        return "cancel complete";
    }
}
