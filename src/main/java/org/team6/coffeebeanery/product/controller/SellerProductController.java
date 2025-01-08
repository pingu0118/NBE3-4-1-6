package org.team6.coffeebeanery.product.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.team6.coffeebeanery.product.model.Product;
import org.team6.coffeebeanery.product.service.SellerProductService;

@RequiredArgsConstructor
@RestController
public class SellerProductController {
    private final SellerProductService sellerProductService;
    
    @GetMapping({"/seller/products"}) //판매자용) 상품 목록 페이지
    public Page<Product> getAllProductList(@RequestParam(value = "page", defaultValue = "0") int page) {
        return this.sellerProductService.getAllProductList(page);
    }
    
    @PostMapping("/seller/products") //판매자용) 새 상품 생성
    public Product createProduct(@Valid @RequestBody Product product) {
        return sellerProductService.createProduct(product);
    }
    
    @PutMapping("/seller/products/{productId}") //판매자용) 기존 상품 정보 수정
    public Product updateProduct(@PathVariable Integer productId, @Valid @RequestBody Product updatedProduct) {
        return sellerProductService.updateProduct(productId, updatedProduct);
    }
    
    @DeleteMapping("/seller/products/{productId}") //판매자용) 상품 삭제
    public void deleteProduct(@PathVariable Integer productId) {
        sellerProductService.deleteProduct(productId);
    }
}
