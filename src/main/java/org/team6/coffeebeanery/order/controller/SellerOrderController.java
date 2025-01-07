package org.team6.coffeebeanery.order.controller;

import lombok.RequiredArgsConstructor;
import org.team6.coffeebeanery.order.service.SellerOrderService;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SellerOrderController {
    private final SellerOrderService sellerOrderService;
    
}
