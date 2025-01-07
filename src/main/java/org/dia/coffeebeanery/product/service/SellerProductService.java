package org.dia.coffeebeanery.product.service;

import lombok.RequiredArgsConstructor;
import org.dia.coffeebeanery.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SellerProductService {
    private final ProductRepository productRepository;
    
}
