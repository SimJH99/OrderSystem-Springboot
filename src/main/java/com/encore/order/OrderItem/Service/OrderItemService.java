package com.encore.order.OrderItem.Service;

import com.encore.order.Item.Domain.Item;
import com.encore.order.Item.Repository.ItemRepository;
import com.encore.order.OrderItem.Domain.OrderItem;
import com.encore.order.OrderItem.Dto.OrderItemListRes;
import com.encore.order.OrderItem.Repository.OrderItemRepository;
import com.encore.order.Ordering.Domain.Ordering;
import com.encore.order.Ordering.Repository.OrderRepository;
import com.encore.order.Ordering.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;
//    private final OrderService orderService;


    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository, ItemRepository itemRepository, OrderRepository orderRepository) {
        this.orderItemRepository = orderItemRepository;
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
    }

    public void save(Long orderId ,List<Long> itemId, List<Long> count) {
        for(int i =0; i < itemId.size(); i++){
            //오더아이템 정보 저장
            OrderItem orderItem = OrderItem.builder()
                    .ordering(orderRepository.findById(orderId).orElseThrow(EntityNotFoundException::new))
                    .item(itemRepository.findById(itemId.get(i)).orElseThrow(EntityNotFoundException::new))
                    .quantity(count.get(i).intValue())
                    .build();
            orderItemRepository.save(orderItem);

            //상품 수량 변경
            Item item = itemRepository.findById(itemId.get(i)).orElseThrow(EntityNotFoundException::new);
            item.orderedQuantity(count.get(i).intValue());
        }
    }

    //주문취소
    public void cancel(Long orderId) {
        List<OrderItem> orderItems = orderItemRepository.findAllByOrderingId(orderId);
        for(OrderItem o : orderItems){
            Item item = itemRepository.findById(o.getId()).orElseThrow(EntityNotFoundException::new);
            item.cancledQuantity(o.getQuantity());
        }
    }

    //주문 번호에 맞는 주문상품조회리스트
    public List<OrderItemListRes> orderItemList(Long id) {
        List<OrderItem> orderItems = orderItemRepository.findAllByOrderingId(id);
        List<OrderItemListRes> orderItemListRes = new ArrayList<>();
        for(OrderItem o : orderItems){
            OrderItemListRes orderItemListRes1 = new OrderItemListRes();
            orderItemListRes1.setOrderId(o.getOrdering().getId());
            orderItemListRes1.setItmeId(o.getItem().getId());
            orderItemListRes1.setCount(o.getQuantity());
            orderItemListRes.add(orderItemListRes1);
        }
        return orderItemListRes;
    }
}
