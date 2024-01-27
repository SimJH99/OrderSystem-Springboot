package com.encore.order.OrderItem.Controller;

import com.encore.order.OrderItem.Service.OrderItemService;
import com.encore.order.Ordering.Domain.Ordering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderItemController {

    private final OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    //주문시 orderItem에 저장될려면 컨트롤러를 동작하도록 하고
    @GetMapping("/orderitems/save")
    @ResponseBody
    public String orderItemSave(Ordering ordering){

        return "ok";
    }
}