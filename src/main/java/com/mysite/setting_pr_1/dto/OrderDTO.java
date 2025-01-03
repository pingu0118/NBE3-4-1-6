package com.mysite.setting_pr_1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
    private String customerEmail;
    private int totalPrice;
    private Long deliveryId;
    private String orderStatus = "결제 완료";
}