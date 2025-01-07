package org.dia.coffeebeanery.order.controller;

import lombok.RequiredArgsConstructor;
import org.dia.coffeebeanery.order.service.SellerOrderService;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SellerOrderController {
    private final SellerOrderService sellerOrderService;
    
}
