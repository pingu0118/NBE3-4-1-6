package org.team6.coffeebeanery.product.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId; //상품 ID
    
    @Column(length = 30)
    private String productName; //상품 이름
    
    @Column(columnDefinition = "TEXT")
    private String productDescription; //상품 설명
    
    private Integer productPrice; //상품 가격
    
    private String productImageURL; //상품 이미지 URL
    
    private Integer productStock; //재고 수량
    
    private LocalDateTime productCreatedAt; //상품 등록일
}