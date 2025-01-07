package org.dia.coffeebeanery.order.repository;

import org.dia.coffeebeanery.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
