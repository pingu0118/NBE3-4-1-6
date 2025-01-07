package org.team6.coffeebeanery.delivery.service;

import lombok.RequiredArgsConstructor;
import org.team6.coffeebeanery.delivery.repository.DeliveryRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;
}
