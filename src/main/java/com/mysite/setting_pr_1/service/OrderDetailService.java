package com.mysite.setting_pr_1.service;

import com.mysite.setting_pr_1.dto.OrderDetailDTO;
import com.mysite.setting_pr_1.entity.Orders;
import com.mysite.setting_pr_1.entity.OrderDetail;
import com.mysite.setting_pr_1.entity.Product;
import com.mysite.setting_pr_1.repository.OrderDetailRepository;
import com.mysite.setting_pr_1.repository.OrderRepository;
import com.mysite.setting_pr_1.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;


    public List<OrderDetail> getOrderDetailsByOrderId(Long orderId) {
        return orderDetailRepository.findByOrders_OrderId(orderId);
    }


    public OrderDetail addOrderDetail(OrderDetailDTO orderDetailDTO) {

        OrderDetail orderDetail = new OrderDetail();


        Product product = productRepository.findById(orderDetailDTO.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다."));


        Orders orders = orderRepository.findById(orderDetailDTO.getOrderId())
                .orElseThrow(() -> new IllegalArgumentException("주문을 찾을 수 없습니다."));


        orderDetail.setProduct(product);
        orderDetail.setOrders(orders);
        orderDetail.setProductQuantity(orderDetailDTO.getProductQuantity());
        orderDetail.setOrderPrice(product.getProductPrice() * orderDetailDTO.getProductQuantity());


        return orderDetailRepository.save(orderDetail);
    }
}
