package com.mysite.pr2.product;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("상품을 찾을 수 없습니다. ID: " + id));
    }

    @Transactional
    public void decreaseStock(Long productId, int quantity) {
        Product product = getProduct(productId);
        if (product.getProductStock() < quantity) {
            throw new IllegalStateException("재고가 부족합니다.");
        }
        product.decreaseStock(quantity);
    }
}
