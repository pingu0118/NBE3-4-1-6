package org.team6.coffeebeanery.order.repository;

import org.team6.coffeebeanery.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
