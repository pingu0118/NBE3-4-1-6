package org.team6.coffeebeanery.delivery.repository;

import org.team6.coffeebeanery.delivery.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {
}