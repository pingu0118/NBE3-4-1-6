package com.mysite.setting_pr_1.service;

import com.mysite.setting_pr_1.dto.OrderDTO;
import com.mysite.setting_pr_1.entity.OrderStatus;
import com.mysite.setting_pr_1.entity.Orders;
import com.mysite.setting_pr_1.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;


    public Orders createOrder(OrderDTO orderDTO) {
        Orders orders = new Orders();
        orders.setCustomerEmail(orderDTO.getCustomerEmail());
        orders.setTotalPrice(orderDTO.getTotalPrice());
        return orderRepository.save(orders);
    }


    @Transactional
    public void updateOrderStatus(Long orderId, OrderStatus status) {
        Orders order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("해당 주문을 찾을 수 없습니다. ID: " + orderId));
        order.setOrderStatus(status);
        orderRepository.save(order);
    }

    @Transactional
    public void cancelOrder(Long orderId) {
        Orders order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("해당 주문을 찾을 수 없습니다. ID: " + orderId));
        orderRepository.delete(order);
    }

    // 이메일로 주문 조회
    public List<Orders> getOrdersByEmail(String email) {
        return orderRepository.findByCustomerEmail(email);
    }
}
