package com.encore.order.Ordering.Controller;

import com.encore.order.Ordering.Domain.Ordering;
import com.encore.order.Ordering.Dto.OrderListReq;
import com.encore.order.Ordering.Dto.OrderReq;
import com.encore.order.Ordering.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //주문목록조회
    @GetMapping("/orders")
    @ResponseBody
    public List<OrderListReq> orderList(OrderListReq orderListReq){
        List<OrderListReq> orderListReqs = orderService.orderList(orderListReq);
        return orderListReqs;
    }

    @PostMapping("/order/new")
    @ResponseBody
    public Ordering Order(OrderReq orderReq){
        Ordering ordering = orderService.save(orderReq);
        return ordering;
    }
}
