package org.team6.coffeebeanery.product.controller;

import lombok.RequiredArgsConstructor;
import org.team6.coffeebeanery.order.service.BuyerOrderService;
import org.team6.coffeebeanery.product.service.SellerProductService;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BuyerProductController {
    private final BuyerOrderService buyerOrderService;
    
}
