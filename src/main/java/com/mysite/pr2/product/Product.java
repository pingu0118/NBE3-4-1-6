package com.mysite.pr2.product;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private Long productPrice;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String productDescription;

    @Column(nullable = false)
    private Integer productStock;

    private String productImageURL;

//    @Column(nullable = false)
//    private String productOrigin;

    // 재고 감소 메서드
    public void decreaseStock(int stockQuantity) {
        this.productStock -= stockQuantity;
    }
}
