package org.dia.coffeebeanery.order.service;

import lombok.RequiredArgsConstructor;
import org.dia.coffeebeanery.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BuyerOrderService {
    private final OrderRepository orderRepository;
    
}
