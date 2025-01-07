package org.dia.coffeebeanery.product.controller;

import lombok.RequiredArgsConstructor;
import org.dia.coffeebeanery.product.service.SellerProductService;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SellerProductController {
    private final SellerProductService sellerProductService;
    
}
