package com.mysite.setting_pr_1.repository;

import com.mysite.setting_pr_1.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findByOrders_OrderId(Long orderId);
}
