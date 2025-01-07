package org.team6.coffeebeanery.product.service;

import lombok.RequiredArgsConstructor;
import org.team6.coffeebeanery.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BuyerProductService {
    private final ProductRepository productRepository;
    
}
