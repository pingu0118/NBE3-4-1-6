package com.mysite.setting_pr_1.controller;

import com.mysite.setting_pr_1.dto.OrderDetailDTO;
import com.mysite.setting_pr_1.entity.OrderDetail;
import com.mysite.setting_pr_1.service.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-details")
@RequiredArgsConstructor
public class OrderDetailController {

    private final OrderDetailService orderDetailService;

    // 주문 상세 조회
    @GetMapping("/{orderId}")
    public ResponseEntity<List<OrderDetail>> getOrderDetails(@PathVariable Long orderId) {
        List<OrderDetail> details = orderDetailService.getOrderDetailsByOrderId(orderId);
        return ResponseEntity.ok(details);
    }


    @PostMapping
    public ResponseEntity<OrderDetail> addOrderDetail(@RequestBody OrderDetailDTO orderDetailDTO) {
        OrderDetail orderDetail = orderDetailService.addOrderDetail(orderDetailDTO);
        return ResponseEntity.ok(orderDetail);
    }
}
