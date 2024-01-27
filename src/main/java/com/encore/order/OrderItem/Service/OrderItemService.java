package com.encore.order.OrderItem.Service;

import com.encore.order.Item.Repository.ItemRepository;
import com.encore.order.OrderItem.Domain.OrderItem;
import com.encore.order.OrderItem.Repository.OrderItemRepository;
import com.encore.order.Ordering.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;


    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository, ItemRepository itemRepository, OrderRepository orderRepository) {
        this.orderItemRepository = orderItemRepository;
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
    }

    public void save(Long orderId ,List<Long> itemId, List<Long> count) {

        for(int i =0; i < itemId.size(); i++){
            OrderItem orderItem = OrderItem.builder()
                    .ordering(orderRepository.findById(orderId).orElseThrow(EntityNotFoundException::new))
                    .item(itemRepository.findById(itemId.get(i)).orElseThrow(EntityNotFoundException::new))
                    .quantity(count.get(i).intValue())
                    .build();

            orderItemRepository.save(orderItem);
        }
    }
}
