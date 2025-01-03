package com.mysite.setting_pr_1.controller;

import com.mysite.setting_pr_1.dto.OrderDTO;
import com.mysite.setting_pr_1.entity.OrderStatus;
import com.mysite.setting_pr_1.entity.Orders;
import com.mysite.setting_pr_1.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    // POST
    @PostMapping
    public ResponseEntity<Orders> createOrder(@RequestBody OrderDTO orderDTO) {
        Orders createdOrders = orderService.createOrder(orderDTO);
        return ResponseEntity.ok(createdOrders);
    }

    // 주문상태 업데이트 PUT
    @PutMapping("/{orderId}/status")
    public ResponseEntity<String> updateOrderStatus(@PathVariable Long orderId, @RequestBody OrderStatus status) {
        orderService.updateOrderStatus(orderId, status);
        return ResponseEntity.ok("Order status updated.");
    }

    // 이메일로 주문 조회 (GET 요청)
    @GetMapping("/{email}")
    public ResponseEntity<List<Orders>> getOrdersByEmail(@PathVariable String email) {
        List<Orders> orders = orderService.getOrdersByEmail(email);
        return ResponseEntity.ok(orders);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> cancelOrder(@PathVariable Long orderId) {
        orderService.cancelOrder(orderId);
        return ResponseEntity.noContent().build();

    }
}
