package org.dia.coffeebeanery.delivery.service;

import lombok.RequiredArgsConstructor;
import org.dia.coffeebeanery.delivery.repository.DeliveryRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;
}
