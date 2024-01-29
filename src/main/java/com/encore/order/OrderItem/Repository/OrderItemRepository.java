package com.encore.order.OrderItem.Repository;

import com.encore.order.OrderItem.Domain.OrderItem;
import com.encore.order.Ordering.Domain.Ordering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findAllByOrdering(Ordering ordering);
}
