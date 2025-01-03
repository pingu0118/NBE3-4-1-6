package com.mysite.setting_pr_1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private String productName;
    private int productPrice;
    private String productDescription;
    private int productStock;
}
