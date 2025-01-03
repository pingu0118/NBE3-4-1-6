package com.mysite.setting_pr_1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailDTO {
    private Long orderId;
    private Long productId;
    private int productQuantity;
    private int productPrice;
}
