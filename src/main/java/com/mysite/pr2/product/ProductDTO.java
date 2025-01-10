package com.mysite.pr2.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Long price;
    private Integer stockQuantity;
    private String imageUrl;
}