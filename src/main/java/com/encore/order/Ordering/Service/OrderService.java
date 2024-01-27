package com.encore.order.Ordering.Service;

import com.encore.order.Member.Domain.Member;
import com.encore.order.Member.Repository.MemberRepository;
import com.encore.order.Member.Service.MemberService;
import com.encore.order.OrderItem.Service.OrderItemService;
import com.encore.order.Ordering.Domain.OrderStatus;
import com.encore.order.Ordering.Domain.Ordering;
import com.encore.order.Ordering.Dto.OrderListReq;
import com.encore.order.Ordering.Dto.OrderReq;
import com.encore.order.Ordering.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

@Service
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemService orderItemService;
    private final MemberRepository memberRepository;


    @Autowired
    public OrderService(OrderRepository orderRepository, OrderItemService orderItemService, MemberRepository memberRepository) {
        this.orderRepository = orderRepository;
        this.orderItemService = orderItemService;
        this.memberRepository = memberRepository;
    }

    public Ordering findById(Long id){
        Ordering ordering = orderRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return ordering;
    }


    public List<OrderListReq> orderList(OrderListReq orderListReq){
        List<Ordering> orderings = orderRepository.findAll();
        List<OrderListReq> orderListReqs = new ArrayList<>();
        for (Ordering o : orderings){
            OrderListReq orderListReq1 = new OrderListReq();
            orderListReq1.setId(o.getId());
            orderListReq1.setOrderStatus(o.getOrderStatus().toString());
            orderListReq1.setMember(o.getMember());
            orderListReq1.setCreatedTime(o.getCreatedTime());
            orderListReqs.add(orderListReq1);
        }
        return orderListReqs;
    }

    public Ordering save(OrderReq orderReq) {
        //주문시 ordering테이블 1건 insert 및 상태 값 ORDERED세팅
        Member member = memberRepository.findById(orderReq.getMemberId()).orElseThrow(EntityNotFoundException::new);
        Ordering ordering = Ordering.builder()
                .member(member)
                .orderStatus(OrderStatus.ORDERED)
                .build();
        orderRepository.save(ordering);

//        Long orderId = ordering.getId();
//        System.out.println(orderId);
//        //주문한 상품 정보와 갯수를 orderitem에 넘긴다.
//        orderItemService.save(orderId, orderReq.getItemId(), orderReq.getCount());
//
        return ordering;
    }

}