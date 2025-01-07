package org.team6.coffeebeanery.delivery.controller;

import lombok.RequiredArgsConstructor;
import org.team6.coffeebeanery.delivery.service.DeliveryService;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class DeliveryController {
    private final DeliveryService deliveryService;
}
