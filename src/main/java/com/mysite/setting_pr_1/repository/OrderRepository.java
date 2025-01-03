package com.mysite.setting_pr_1.repository;

import com.mysite.setting_pr_1.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long> {
    List<Orders> findByCustomerEmail(String customerEmail);
}
